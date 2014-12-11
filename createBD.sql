CREATE TABLE SECTEUR (SEC_CODE VARCHAR2(1) NOT NULL, SEC_LIBELLE VARCHAR2(15) NULL, PRIMARY KEY (SEC_CODE))
CREATE TABLE LABO (LAB_CODE VARCHAR2(2) NOT NULL, LAB_CHEFVENTE VARCHAR2(20) NULL, LAB_NOM VARCHAR2(10) NULL, PRIMARY KEY (LAB_CODE))
CREATE TABLE VISITEUR (VIS_MATRICULE VARCHAR2(10) NOT NULL, VIS_ADRESSE VARCHAR2(50) NULL, VIS_CP VARCHAR2(5) NULL, VIS_DATEEMBAUCHE DATE NULL, VIS_NOM VARCHAR2(25) NULL, Vis_PRENOM VARCHAR2(50) NULL, VIS_VILLE VARCHAR2(30) NULL, LAB_CODE VARCHAR2(2) NULL, SEC_CODE VARCHAR2(1) NULL, PRIMARY KEY (VIS_MATRICULE))
ALTER TABLE VISITEUR ADD CONSTRAINT FK_VISITEUR_SEC_CODE FOREIGN KEY (SEC_CODE) REFERENCES SECTEUR (SEC_CODE)
ALTER TABLE VISITEUR ADD CONSTRAINT FK_VISITEUR_LAB_CODE FOREIGN KEY (LAB_CODE) REFERENCES LABO (LAB_CODE)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR2(50) NOT NULL, SEQ_COUNT NUMBER(38) NULL, PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
