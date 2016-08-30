package com.creation.lalahmode.persistence;

import java.util.Properties;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Classe de configuration de JPA chargée par Spring.
 * 
 * @author Infotel
 */
@Configuration
@EnableTransactionManagement
@Profile("default")
// @PropertySource({ "classpath:persistence-mysql.properties" })
public class PersistenceConfig {

    /** Nom du schema par défaut. */
    public static final String SCHEMA_PAR_DEFAUT = "public.";

    /** Logger. */
    private static final Logger LOGGER = Logger.getLogger(PersistenceConfig.class);

    /**
     * Récupération de la datasource dans le JNDI.
     * 
     * @return the data source
     * @throws NamingException
     *             the naming exception
     */
    @Bean(name = "LalahmodeDs")
    @Singleton
    public DataSource getDataSource() throws NamingException {
        final String dataSourceJndi = "java:comp/env/jdbc/lalahmodeds";
        LOGGER.debug(String.format("recuperation de la datasource %s", dataSourceJndi));
        if (StringUtils.isBlank(dataSourceJndi)) {
            throw new NamingException("La datasource dans la configuration WAS est nulle !");
        }
        return InitialContext.doLookup(dataSourceJndi);
    }

    /**
     * Fabrication d'une fabrique de gestionnaire d'entité.
     * 
     * @param pDataSource
     *            la datasource, produite dans cette même classe.
     * @return une fabrique d'entity manager.
     */
    @Bean(name = "LalahmodeEm")
    @Singleton
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(@Singleton @Named("LalahmodeDs") final DataSource pDataSource) {
        LOGGER.debug("creation de l'entity manager factory");
        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(pDataSource);
        factoryBean.setPackagesToScan(new String[] {"com.mcreation.lalahmode.donnees", "com.mcreation.lalahmode.dao"});
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());

        return factoryBean;
    }

    /**
     * Création du gestionnaire de transaction. On utilise celui de JPA fourni par Spring.
     * 
     * @param pEntiManangerFactory
     *            la fabrique de gestionnaire d'entité.
     * @return un transaction manager adapté à la plateforme.
     */
    @Bean(name = "LalahmodeTxManager")
    public PlatformTransactionManager getPlatformTransactionManager(
            @Singleton @Named("LalahmodeEm") final EntityManagerFactory pEntiManangerFactory) {
        LOGGER.debug("creation du transaction manager");
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(pEntiManangerFactory);
        return transactionManager;
    }

    /**
     * Retourne les propriétés de configuration d'Hibernate.
     * 
     * @return une liste de propriétés
     */
    private Properties hibernateProperties() {
        Properties props = new Properties();
        // props.setProperty("hibernate.hbm2ddl.auto", "");
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        props.setProperty("hibernate.show_sql", "false");
        props.setProperty("hibernate.default_schema", "public");
        props.setProperty("hibernate.discriminator.ignore_explicit_for_joined", "true");
        return props;
    }
}
