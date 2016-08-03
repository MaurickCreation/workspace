package com.mcreation.lalahmode.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import com.mcreation.lalahmode.dao.IDao;

/**
 * Implémentation du DAO générique.
 * @author gpmb2
 * @param <T>
 *            Le type de l'entité persistante
 * @param <PK>
 *            Le type de la clé primaire de l'entité
 */
public abstract class AbstractDao<T, PK> implements IDao<T, PK> {

    /**
     * Enumération des différents types de requête.
     * @author Infotel
     */
    private enum QueryType {
        /** Requête JPQL. */
        QUERY,
        /** Requête SQL. */
        NATIVE_QUERY,
        /** Requête nommée. */
        NAMED_QUERY
    }

    /** Le gestionnaire d'entités. */
    @PersistenceContext(name = "persistence/LalahmodePu", unitName = "LalahmodeEm")
    private EntityManager em;

    /** Le type de l'entité de la classe fille. */
    private Class<T> type = null;

    /**
     * Constructeur. Le type de l'objet persistant est déterminé par reflection.
     */
    protected AbstractDao() {
        this.type = this.getParameterizedType(this.getClass());
    }

    /**
     * Supprime les doublons d'une liste de résultats.
     * @param resultList
     *            une liste de résultat.
     * @return une liste de résultats ne contenant aucun doublon.
     */
    protected List<T> getUniqueResultsList(final List<T> resultList) {
        Set<T> setUniqueEntities = new LinkedHashSet<T>(resultList);
        resultList.clear();
        resultList.addAll(setUniqueEntities);
        return resultList;
    }

    /**
     * Retrouve le type paramétré de la classe générique.
     * @param clazz
     *            une class.
     * @return le type paramétré de la classe
     */
    @SuppressWarnings("unchecked")
    private Class<T> getParameterizedType(final Class<?> clazz) {
        Class<T> specificType = null;
        final ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        specificType = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        return specificType;
    }

    @Override
    public void flush() {
        this.em.flush();
    }

    @Override
    public void detache(final T o) {
        this.em.detach(o);
    }

    @Override
    public void persist(final T o) {
        this.em.persist(o);
    }

    @Override
    public T merge(final T o) {
        return this.em.merge(o);
    }

    @Override
    public void remove(final T o) {
        this.em.remove(o);
    }

    @Override
    public void refresh(final T o) {
        this.em.refresh(o);
    }

    @Override
    public void lock(final T o) {
        this.em.lock(o, LockModeType.OPTIMISTIC);
    }

    @Override
    public T find(final PK primaryKey) {
        return this.em.find(this.type, primaryKey);
    }

    @Override
    public T getReference(final PK primaryKey) {
        return this.em.getReference(this.type, primaryKey);
    }

    @Override
    @SuppressWarnings("unchecked")
    public final List<T> findAll() {
        return this.em.createQuery("SELECT x FROM " + this.type.getSimpleName() + " x").getResultList();
    }

    @Override
    public final List<T> executeNamedQuery(final String queryName, final String pParamKey, final Object pParamValue) {
        return getEntityList(queryName, Collections.singletonMap(pParamKey, pParamValue), QueryType.NAMED_QUERY);
    }

    @Override
    public final int executeNamedQueryForUpdate(final String queryName, final Map<String, Object> parameters) {
        Query query = createQuery(queryName, parameters, QueryType.NAMED_QUERY);
        return query.executeUpdate();
    }

    @Override
    public final List<T> executeNamedQuery(final String queryName, final Map<String, Object> parameters) {
        return getEntityList(queryName, parameters, QueryType.NAMED_QUERY);
    }

    @Override
    public final List<T> executeNamedQuery(final String queryName) {
        return getEntityList(queryName, QueryType.NAMED_QUERY);
    }

    @Override
    public final List<?> executeStoredProcedure(final String storedProcedureName, final Map<String, Object> parameters) {
        StoredProcedureQuery storedProcedure = this.em.createNamedStoredProcedureQuery(storedProcedureName);
        if (parameters != null) {
            // La définition des paramètres en entrée doit se faire dans la déclaration de la procédure stockée.
            for (Entry<String, Object> entry : parameters.entrySet()) {
                storedProcedure.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return storedProcedure.getResultList();
    }

    @Override
    public List<T> chercheParLibelle(final String label) {
        StringBuilder query = new StringBuilder("from ");
        query.append(this.type.getSimpleName());
        query.append(" t where upper(t.");
        query.append(getLabelColumn());
        query.append(") like :label");
        query.append(" and archivage = 0");

        return executeQuery(query.toString(), Collections.singletonMap("label", (Object) String.format("%%%s%%", label.toUpperCase())));
    }

    /**
     * Exécute une Query paramétrée et renvoie tous les éléments trouvés.
     * @param queryString
     *            Instructions JPQL.
     * @param parameters
     *            Paramètres de la requête sous la forme d'une map (clef: nom du paramètre, valeur: valeur du paramètre).
     * @return Retourne les résultats de la requête.
     */
    protected final List<T> executeQuery(final String queryString, final Map<String, Object> parameters) {
        return getEntityList(queryString, parameters, QueryType.QUERY);
    }

    /**
     * Exécute une requête SQL et renvoie tous les éléments trouvés.
     * @param queryString
     *            Instructions JPQL.
     * @param parameters
     *            Paramètres de la requête sous la forme d'une map (clef: nom du paramètre, valeur: valeur du paramètre).
     * @return Retourne les résultats de la requête.
     */
    protected final List<T> executeNativeQuery(final String queryString, final Map<String, Object> parameters) {
        return getEntityList(queryString, parameters, QueryType.NATIVE_QUERY);
    }

    /**
     * Exécute une Query paramétrée de mise a jour.
     * @param queryString
     *            Instructions JPQL.
     * @param parameters
     *            Paramètres de la requête sous la forme d'une map (clef: nom du paramètre, valeur: valeur du paramètre).
     */
    protected void executeQueryUpdate(final String queryString, final Map<String, Object> parameters) {

        // Création de la requête
        final Query query = createQuery(queryString, parameters, QueryType.QUERY);

        // Exécution de la requête
        query.executeUpdate();
    }

    /**
     * Retourne le nom la colonne contenant le libellé.
     * @return le nom de la colonne
     */
    protected String getLabelColumn() {
        return DEFAULT_LABEL_COLUMN_NAME;
    }

    /**
     * Exécute une requête JPQL et renvoie tous les éléments trouvés.
     * @param queryString
     *            Instruction JPQL ou nom de NamedQuery.
     * @param parameters
     *            Paramètres de la requête sous la forme d'une map (clef: nom du paramètre, valeur: valeur du paramètre).
     * @param queryType
     *            Type de Query à créer : Query, NamedQuery ou NativeQuery.
     * @return Retourne les résultats de la requête.
     */
    @SuppressWarnings("unchecked")
    private List<T> getEntityList(final String queryString, final Map<String, Object> parameters, final QueryType queryType) {

        // Création de la requête
        final Query query = createQuery(queryString, parameters, queryType);

        // Exécution de la requête : on retourne la liste complète des résultats
        return getUniqueResultsList(query.getResultList());
    }

    /**
     * Exécute une requête JPQL et renvoie tous les éléments trouvés.
     * @param queryString
     *            Instruction JPQL ou nom de NamedQuery.
     * @param queryType
     *            Type de Query à créer : Query, NamedQuery ou NativeQuery.
     * @return Retourne les résultats de la requête.
     */
    @SuppressWarnings("unchecked")
    private List<T> getEntityList(final String queryString, final QueryType queryType) {

        // Création de la requête
        final Query query = createQuery(queryString, queryType);

        // Exécution de la requête : on retourne la liste complète des résultats
        return getUniqueResultsList(query.getResultList());
    }

    /**
     * Création d'une requête JPA.
     * @param queryString
     *            Instructions JPQL ou nom de la NamedQuery.
     * @param parameters
     *            Paramètres de la requête sous la forme d'une map (clef: nom du paramètre, valeur: valeur du paramètre).
     * @param queryType
     *            Type de Query à créer : Query, NamedQuery ou NativeQuery.
     * @return Retourne l'objet Query crée.
     */
    private Query createQuery(final String queryString, final Map<String, Object> parameters, final QueryType queryType) {

        // Création de l'objet Query
        Query query = null;
        switch (queryType) {

        // NamedQuery
        case NAMED_QUERY:
            query = this.em.createNamedQuery(queryString);
            break;

        // NativeQuery
        case NATIVE_QUERY:
            query = this.em.createNativeQuery(queryString, this.type);
            break;

        // Query
        case QUERY:
            query = this.em.createQuery(queryString);
            break;

        default:
            break;
        }

        // Configuration des paramètres
        String paramName = "";
        Object paramValue = null;
        if (parameters != null) {
            for (final Map.Entry<String, Object> item : parameters.entrySet()) {
                paramName = item.getKey();
                paramValue = item.getValue();
                query.setParameter(paramName, paramValue);
            }
        }

        return query;
    }

    /**
     * Création d'une requête JPA.
     * @param queryString
     *            Instructions JPQL ou nom de la NamedQuery.
     * @param queryType
     *            Type de Query à créer : Query, NamedQuery ou NativeQuery.
     * @return Retourne l'objet Query crée.
     */
    private Query createQuery(final String queryString, final QueryType queryType) {
        final Map<String, Object> parameters = Collections.emptyMap();
        return createQuery(queryString, parameters, queryType);
    }

    /**
     * Getter for the em attribute.
     * @return em the attribute value
     */
    public final EntityManager getEntityManager() {
        return this.em;
    }
}
