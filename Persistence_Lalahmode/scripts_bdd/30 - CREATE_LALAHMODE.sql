
/***********************************************************
    G�n�ration
    Plugiciel : Moteur pour la g�n�ration de DDL ANSI (3.2.0 - 05-12-2009), Grandite
    Nom de la base de donn�es : "Base de donn�es"
    Fichier source : "D:\Vie_professionnelle\ConsultantIT_Architecte_Solutions\Conception_LAlahmode\LalahMode.sms"
    G�n�r� le : 2 d�c. 2015 23:16:57
    G�n�r� par Open ModelSphere Version 3.2"
***********************************************************/


/***********************************************************
    DROP STATEMENTS
***********************************************************/


DROP TABLE TA_ARTICLE;

DROP TABLE TA_FOURNISSEUR;

DROP TABLE TA_UTILISATEUR;

DROP TABLE TA_ENTETE_COMMANDE;



/***********************************************************
    CREATE STATEMENTS
***********************************************************/


CREATE TABLE TA_ARTICLE 
(
    ID_ARTICLE INTEGER NOT NULL,
    CODE_ART VARCHAR(8) NOT NULL,
    LIBELLE VARCHAR(30) NULL,
    PRIX NUMERIC(15,2) NULL,
    NOM_IMAGE VARCHAR(50) NULL
);


CREATE TABLE TA_FOURNISSEUR 
(
    id_four INTEGER NOT NULL,
    code_four VARCHAR(8) NOT NULL,
    libelle VARCHAR(30) NULL,
    Pays VARCHAR(15) NULL,
    description VARCHAR(50) NULL
);

-- Table: ta_utilisateur


CREATE TABLE ta_utilisateur
(
  ID_UTIL integer NOT NULL,
  LOGIN VARCHAR(50),
  MDP VARCHAR(20),
  NOM VARCHAR(50),
  PRENOM VARCHAR(50),
  TEL VARCHAR(10),
  ADRESSE VARCHAR(40),
  CONSTRAINT PK_TA_UTILISATEUR PRIMARY KEY (ID_UTIL)
)
;
    -- Table Entete de commande
    
    
    CREATE TABLE TA_ENTETE_COMMANDE (
    NUM_COMMANDE integer NOT NULL,
  DATE_COMMANDE VARCHAR(8),
  NUM_CLIENT integer,
  DATE_VALIDATION VARCHAR(8),
  DATE_LIVRAISON VARCHAR(8)
  );


ALTER TABLE TA_ARTICLE 
  ADD CONSTRAINT PK_ARTICLE PRIMARY KEY (
    ID_ARTICLE, CODE_ART)  ;
ALTER TABLE TA_FOURNISSEUR 
  ADD CONSTRAINT PK_FOURNISSEUR PRIMARY KEY (
    id_four, code_four)  ;
   
    ALTER TABLE TA_ENTETE_COMMANDE 
  ADD CONSTRAINT PK_COMMANDE_ENT PRIMARY KEY (
    num_commande)  ;
    
    

    
    
    -- Sequence: seq_ta_article

DROP SEQUENCE seq_ta_article;
 DROP SEQUENCE SEQ_TA_UTILISATEUR;
 drop sequence SEQ_TA_ENTETE_COMMANDE;

CREATE SEQUENCE seq_ta_article
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9999999
  START 1
  CACHE 1;
ALTER TABLE seq_ta_article
  OWNER TO lalahmode;
GRANT ALL ON SEQUENCE seq_ta_article TO lalahmode;



CREATE SEQUENCE SEQ_TA_UTILISATEUR
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999
  START 1
  CACHE 1;
ALTER TABLE SEQ_TA_UTILISATEUR
  OWNER TO lalahmode;
  GRANT ALL ON SEQUENCE SEQ_TA_UTILISATEUR TO lalahmode;
  
  CREATE SEQUENCE SEQ_TA_ENTETE_COMMANDE
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9999999999
  START 1
  CACHE 1;
ALTER TABLE SEQ_TA_ENTETE_COMMANDE
  OWNER TO lalahmode;
  GRANT ALL ON SEQUENCE SEQ_TA_UTILISATEUR TO lalahmode;


    END
    
    

