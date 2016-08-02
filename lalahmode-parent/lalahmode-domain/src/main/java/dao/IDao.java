package dao;

import java.util.List;
import java.util.Map;

/**
 * Interface générique pour les DAOs.
 * @author gpmb2
 * @param <T>
 *            le type de l'objet persistant.
 * @param <PK>
 *            le type de la clé primaire de l'objet persistant.
 */
public interface IDao<T, PK> {

    /** Nom par défaut de la colonne contenant le libellé. */
    String DEFAULT_LABEL_COLUMN_NAME = "libelle";

    /**
     * Synchronise les objets de l'entityManager avec la base de données.
     */
    void flush();

    /**
     * Détache un objet persistant de la session.
     * @param o
     *            l'objet persistant à détacher.
     */
    void detache(final T o);

    /**
     * Rafraîchit un objet persistant.
     * @param o
     *            l'objet à rafraîchir.
     */
    void refresh(T o);

    /**
     * Sauvegarde un objet en base de données.
     * @param o
     *            l'objet à sauvegarder.
     */
    void persist(T o);

    /**
     * Met à jour un objet en base de données, ou le crée s'il n'existe pas.
     * @param o
     *            l'objet à mettre à jour.
     * @return l'objet mis à jour.
     */
    T merge(T o);

    /**
     * Supprime un objet en base de données.
     * @param o
     *            l'objet persistant à supprimer.
     */
    void remove(T o);

    /**
     * Charge une objet depuis la base de données à partir de son identifiant.
     * @param id
     *            identifiant de l'objet persistant
     * @return T un objet persistant chargé depuis la base de données.
     */
    T find(PK id);

    /**
     * Charge une objet depuis la base de données à partir de son identifiant. S'il n'existe pas une exception est lancée.
     * @param id
     *            identifiant de l'objet persistant
     * @return T un objet persistant chargé depuis la base de données.
     */
    T getReference(PK id);

    /**
     * Charge tous les objets du type spécifié par le DAO depuis la base de données.
     * @return List une liste d'objets persistants
     */
    List<T> findAll();

    /**
     * Applique un verrou sur l'entité tant que la transaction n'est pas terminée.
     * @param o
     *            une entité
     */
    void lock(final T o);

    /**
     * Charge tous les objets dont la colonne passée en paramètre contient la valeur 'label' passée en paramètre.
     * @param label
     *            la valeur
     * @return une liste d'objets persistants.
     */
    List<T> chercheParLibelle(final String label);

    /**
     * Execute named query.
     * @param queryName
     *            the query name
     * @param pParamKey
     *            the param key
     * @param pParamValue
     *            the param value
     * @return the list
     */
    List<T> executeNamedQuery(final String queryName, final String pParamKey, final Object pParamValue);

    /**
     * Exécute une NamedQuery paramétrée et renvoie tous les éléments trouvés.
     * @param queryName
     *            Nom de la NamedQuery.
     * @param parameters
     *            Paramètres de la requête sous la forme d'une map (clef: nom du paramètre, valeur: valeur du paramètre).
     * @return Retourne les résultats de la requête.
     */
    List<T> executeNamedQuery(final String queryName, final Map<String, Object> parameters);

    /**
     * Exécute une NamedQuery sans paramètres et renvoie tous les éléments trouvés.
     * @param queryName
     *            Nom de la NamedQuery.
     * @return Retourne les résultats de la requête.
     */
    List<T> executeNamedQuery(final String queryName);

    /**
     * Exécute une procédure stockée.
     * @param queryName
     *            Nom de la NamedQuery.
     * @param parameters
     *            Paramètres de la requête sous la forme d'une map (clef: nom du paramêtre, valeur: valeur du paramêtre).
     * @return Si le résultat de la procédure stockée est mappée avec une seule classe, alors retourne une liste de résultat typée.<br> S'il
     *         est mappée avec plusieurs classes, alors retourne une liste d'objets contenant les objets instanciées par la mapping (autant
     *         d'objets que de classes mappées).
     */
    List<?> executeStoredProcedure(final String queryName, final Map<String, Object> parameters);

    /**
     * Exécute une requête nommée de type UPDATE ou DELETE.
     * @param queryName
     *            le nom de la requête nommée.
     * @param parameters
     *            la liste des paramètres
     * @return le statut renvoyé par la BDD.
     */
    int executeNamedQueryForUpdate(final String queryName, final Map<String, Object> parameters);

}
