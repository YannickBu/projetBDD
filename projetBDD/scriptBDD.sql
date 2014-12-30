drop table appartient;
drop table equipe;
drop table enseigne;
drop table enseignant;
drop table inscription;
drop table note;
drop table controle_connaissance;
drop table EC;
drop table UE;
drop table formation;
drop table etudiant;
drop sequence seq_cc;

create sequence seq_cc START WITH 1 INCREMENT BY 1;

CREATE TABLE ETUDIANT
(    "IDETU" NUMBER(6,0),
    "NOMETU" VARCHAR2(50 BYTE),
    "PRENOMETU" VARCHAR2(50 BYTE)
);

 CREATE TABLE FORMATION
   (    "IDFORM" NUMBER,
    "LIBFORM" VARCHAR2(50 BYTE),
    "ANNEEFORM" VARCHAR2(20 BYTE),
    "SEMESTREFORM" NUMBER(1,0)
   );


  CREATE TABLE ENSEIGNANT
   (    "IDENSEIGN" NUMBER,
    "NOMENSEIGN" VARCHAR2(20 BYTE),
    "PRENOMENSEIGN" VARCHAR2(20 BYTE)
   );

  CREATE TABLE ENSEIGNE
   (    "IDENSEIGNE" NUMBER,
    "IDUE" NUMBER
   );

  CREATE TABLE EC
   (    "IDEC" NUMBER,
    "IDUE" NUMBER,
    "LIBEC" VARCHAR2(100 BYTE),
    "RACEC" VARCHAR2(20 BYTE),
    "COEFFEC" NUMBER(2,0)
   );

  CREATE TABLE UE
   (    "IDUE" NUMBER,
    "IDFORM" NUMBER,
    "LIBUE" VARCHAR2(100 BYTE),
    "RACUE" VARCHAR2(20 BYTE),
    "NBCREDITUE" NUMBER(2,0)
   );



  CREATE TABLE INSCRIPTION
   (    "IDETU" NUMBER,
    "IDUE" NUMBER
   );

  CREATE TABLE CONTROLE_CONNAISSANCE
   (    "IDCC" NUMBER,
    "IDEC" NUMBER,
    "NUMSESSION" NUMBER,
    "NOTEMAXCC" NUMBER(2,0),
    "TYPECC" VARCHAR2(20 BYTE),
    "SSTYPECC" VARCHAR2(20 BYTE),
    "COEFF" NUMBER(2,0)
   );

  CREATE TABLE NOTE
   (    "IDETU" NUMBER,
    "IDCC" NUMBER,
    "NOTECC" NUMBER(2,0)
   );

   CREATE TABLE EQUIPE
    (   "IDEQUIPE"   NUMBER,
    "IDCC"         NUMBER,
    "NOTE_EQUIPE" NUMBER
    );

    CREATE TABLE APPARTIENT
    (    "IDEQUIPE"     NUMBER,
    "IDETU"        NUMBER
    );

/* PRIMARY KEY */
alter table enseignant add constraint enseignant_pk primary key (idEnseign);

alter table etudiant add constraint etudiant_pk primary key  (idEtu);

alter table formation add constraint formation_pk primary key  (idForm);

alter table EC add constraint EC_pk primary key  (idEC);

alter table UE add constraint UE_pk primary key  (idUE);

alter table controle_connaissance add constraint controle_connaissance_pk primary key  (idCC);

alter table enseigne add constraint enseigne_pk primary key  (idenseigne, idue);

alter table inscription add constraint inscription_pk primary key  (idue, idetu);

alter table note add constraint note_pk primary key  (idetu, idcc);

alter table equipe add constraint equipe_pk primary key (idequipe);

alter table appartient add constraint appartient_pk primary key(idequipe, idetu);


/*FOREIGN KEY  */
alter table inscription add constraint inscription_etudiant foreign key (idetu) references etudiant;
alter table inscription add constraint inscription_ue foreign key (idue) references ue;
alter table enseigne add constraint enseigne_ue foreign key (idue) references ue;
alter table enseigne add constraint enseigne_enseignant foreign key (idenseigne) references enseignant;

alter table ec add constraint ec_ue foreign key (idue) references ue;

alter table ue add constraint ue_formation foreign key (idForm) references formation;

alter table controle_connaissance add constraint controle_connaissance_ec foreign key (idec) references ec;

alter table note add constraint note_etudiant foreign key (idetu) references etudiant;
alter table note add constraint note_controle_connaissance foreign key (idcc) references controle_connaissance;

alter table equipe add constraint equipe_cc foreign key (idcc) references controle_connaissance;

alter table appartient add constraint appartient_etudiant foreign key (idetu) references etudiant;
alter table appartient add constraint appartient_equipe foreign key (idequipe) references equipe;


/* CHECK */
alter table ue add constraint check_credit_ue check (nbcreditue > 0);

alter table ec add constraint check_coeff_ec check (coeffec > 0);

alter table controle_connaissance add constraint check_coeff_cc check (coeff > 0);

alter table equipe add constraint check_note_equipe check (note_equipe >= 0);

alter table note add constraint check_note check (noteCC >= 0);

alter table formation add constraint check_semestre check (semestreform > 0 and semestreform <=6);

alter table controle_connaissance add constraint check_typecc check (typecc in ('examen','controle continu'));
alter table controle_connaissance add constraint check_sstype_in check (sstypecc in ('individuel','equipe'));
alter table controle_connaissance add constraint check_sstype check ((sstypecc='individuel' and typecc ='examen' ) or typecc='controle continu');

/* INSERT */


Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (1,'Wuilbeaux','Alois');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (2,'Hequet','Pierre-Louis');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (71,'Bahbah','Sarra');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (72,'Balde','Saikou-oumar');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (73,'Barrois','Manon');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (74,'Buchart','Yannick');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (75,'Dauchy','Michael');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (76,'Declerck','Rodolphe');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (77,'Delobelle','Anthony');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (78,'Delporte','Jerome');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (79,'Gidon','Maxime');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (80,'Grimponprez','Jean-Baptiste');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (82,'Kabri','Yamina');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (83,'Laaboud','AbdelBaqui');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (84,'Labbe','Sebastien');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (85,'Laboub','Salona');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (86,'Laujac','Quentin');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (87,'Marquette','Camille');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (88,'Pierard','Thomas');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (89,'Amara','Djamel');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (81,'Aubry','Thomas');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (3,'Azaroual','Zakariae');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (4,'Bah','Mamadou-Bachir');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (5,'Bahaoui','Hind');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (6,'Bailleul','Pierre');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (7,'Bakandzhizva','Irina');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (8,'Bekkai','Soukaina');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (9,'Bergeus','Guillaume');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (10,'Bienvenu','Alexandre');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (11,'Binois','Jimmy');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (12,'Blain','Melissa');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (13,'Blairon','Clément');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (14,'Boucher','Maxime');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (15,'Boutrouille','Alexis');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (16,'Boutrouille','Maxime');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (17,'Briche','Maxime');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (18,'Bruffaert','Florian');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (19,'Capizzi','Lesly-Anne');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (20,'Catte','Matthieu');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (21,'Cornet','Guillaume');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (22,'David','Franck');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (23,'Debieve','Ophelie');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (24,'Deleforterie','Karl');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (25,'Deparis','Thomas');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (26,'Descamps','Dimitri');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (27,'Duhaupas','Clement');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (28,'Duquesnoy ','Julien');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (29,'Floquet','Emeric');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (30,'Frangi','Romain');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (31,'Frayer','Pierre');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (32,'Freville','Mathieu');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (33,'Frezin','Gilles');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (34,'Germain De Montauzan','Maxence');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (35,'Ghannam','Houda');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (36,'Gohard','Martin');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (37,'Goubel','Antoine');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (38,'Hadhri','Wissem');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (39,'Hassaine','Nassim');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (40,'Heyte','Fabien');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (41,'Kaczmarek','Remi');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (42,'Koma ','Xavier');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (43,'Koubâa','Ines');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (44,'Laethem','Christopher');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (45,'Langlois','Julien');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (46,'Ledoux','Charlotte');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (47,'Lenquette','Cedric');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (48,'Lesage','Pierrick');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (49,'Magnier','Sylvain');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (50,'Mainvis','Terry');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (51,'Makhout','Zouhair');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (52,'Mantel','Sophie');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (53,'Mantel','Sophie ');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (54,'Noto ','Nicolas');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (55,'Poret','Basile-Carlos-Albert');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (56,'Prud homme','Maxime');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (57,'Ramelot','Pierrre');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (58,'Sano','Latifou');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (59,'Simon','Martin');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (60,'Tabet','Ahmed Jawad ');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (61,'Vandemeulebrouck','Nicolas');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (62,'Vanpeene','Maxime');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (63,'Wyckaert','Jerome');
Insert into ETUDIANT (idEtu,nomEtu,prenomEtu) values (64,'Zoonekynd','Vivien');

Insert into ENSEIGNANT (IDENSEIGN,NOMENSEIGN,PRENOMENSEIGN) values (1,'Bossut','Francis');
Insert into ENSEIGNANT (IDENSEIGN,NOMENSEIGN,PRENOMENSEIGN) values (2,'Melab','Nourdine');
Insert into ENSEIGNANT (IDENSEIGN,NOMENSEIGN,PRENOMENSEIGN) values (3,'Lebbe','Jean-Marie');
Insert into ENSEIGNANT (IDENSEIGN,NOMENSEIGN,PRENOMENSEIGN) values (4,'Chauvier','Jean-Yves');
Insert into ENSEIGNANT (IDENSEIGN,NOMENSEIGN,PRENOMENSEIGN) values (5,'Caron','Anne-Cecile');
Insert into ENSEIGNANT (IDENSEIGN,NOMENSEIGN,PRENOMENSEIGN) values (6,'Derbel','Bilel');
Insert into ENSEIGNANT (IDENSEIGN,NOMENSEIGN,PRENOMENSEIGN) values (7,'Camboulives','Vincent');

Insert into FORMATION (IDFORM,LIBFORM,ANNEEFORM,SEMESTREFORM) values (1,'M1MIAGE','2014/2015',1);
Insert into FORMATION (IDFORM,LIBFORM,ANNEEFORM,SEMESTREFORM) values (2,'M1MIAGE','2014/2015',2);
Insert into FORMATION (IDFORM,LIBFORM,ANNEEFORM,SEMESTREFORM) values (3,'M1MIAGE','2013/2014',1);
Insert into FORMATION (IDFORM,LIBFORM,ANNEEFORM,SEMESTREFORM) values (4,'M1MIAGE','2013/2014',2);

Insert into UE (IDUE,IDFORM,LIBUE,RACUE,NBCREDITUE) values (1,1,'Base de donnees','BD',5);
Insert into UE (IDUE,IDFORM,LIBUE,RACUE,NBCREDITUE) values (2,1,'Conception Orientation Objet','COO',5);
Insert into UE (IDUE,IDFORM,LIBUE,RACUE,NBCREDITUE) values (3,1,'Entrepôts de données','ED',4);
Insert into UE (IDUE,IDFORM,LIBUE,RACUE,NBCREDITUE) values (4,1,'Gestion de production et Recherche opérationnelle','GPRO',6);
Insert into UE (IDUE,IDFORM,LIBUE,RACUE,NBCREDITUE) values (5,1,'Analyse Financière et Jeu d''entreprise ','AFJE',5);
Insert into UE (IDUE,IDFORM,LIBUE,RACUE,NBCREDITUE) values (6,1,'Conduite de projet en entreprise','CPE',5);

Insert into ENSEIGNE (IDENSEIGNE,IDUE) values (1,1);
Insert into ENSEIGNE (IDENSEIGNE,IDUE) values (2,4);
Insert into ENSEIGNE (IDENSEIGNE,IDUE) values (3,5);
Insert into ENSEIGNE (IDENSEIGNE,IDUE) values (4,4);
Insert into ENSEIGNE (IDENSEIGNE,IDUE) values (5,3);
Insert into ENSEIGNE (IDENSEIGNE,IDUE) values (6,2);
Insert into ENSEIGNE (IDENSEIGNE,IDUE) values (7,6);
Insert into EC (IDEC,IDUE,LIBEC,RACEC,COEFFEC) values (1,1,'Base de donnees','BD',10);
Insert into EC (IDEC,IDUE,LIBEC,RACEC,COEFFEC) values (2,2,'Conception orientation objet','COO',10);
Insert into EC (IDEC,IDUE,LIBEC,RACEC,COEFFEC) values (3,3,'Entrepots de donnees','ED',10);
Insert into EC (IDEC,IDUE,LIBEC,RACEC,COEFFEC) values (4,4,'Gestion de production','GP',5);
Insert into EC (IDEC,IDUE,LIBEC,RACEC,COEFFEC) values (5,4,'Recherche operationnelle','RO',5);
Insert into EC (IDEC,IDUE,LIBEC,RACEC,COEFFEC) values (6,5,'Analyse financiere','AF',5);
Insert into EC (IDEC,IDUE,LIBEC,RACEC,COEFFEC) values (7,5,'Jeu d''entreprise','JE',5);
Insert into EC (IDEC,IDUE,LIBEC,RACEC,COEFFEC) values (8,6,'Gestion de projet','GP',5);
Insert into EC (IDEC,IDUE,LIBEC,RACEC,COEFFEC) values (9,6,'Demain en entreprise','DEE',5);

insert into inscription values(71,1);
insert into inscription values(72,1);
insert into inscription values(73,1);
insert into inscription values(74,1);
insert into inscription values(75,1);
insert into inscription values(76,1);
insert into inscription values(77,1);
insert into inscription values(78,1);
insert into inscription values(79,1);
insert into inscription values(80,1);
insert into inscription values(2,1);
insert into inscription values(81,1);
insert into inscription values(82,1);
insert into inscription values(83,1);
insert into inscription values(84,1);
insert into inscription values(85,1);
insert into inscription values(86,1);
insert into inscription values(87,1);
insert into inscription values(1,1);

insert into inscription values(71,2);
insert into inscription values(72,2);
insert into inscription values(73,2);
insert into inscription values(74,2);
insert into inscription values(75,2);
insert into inscription values(76,2);
insert into inscription values(77,2);
insert into inscription values(78,2);
insert into inscription values(79,2);
insert into inscription values(80,2);
insert into inscription values(2,2);
insert into inscription values(81,2);
insert into inscription values(82,2);
insert into inscription values(83,2);
insert into inscription values(84,2);
insert into inscription values(85,2);
insert into inscription values(86,2);
insert into inscription values(87,2);
insert into inscription values(1,2);

insert into inscription values(71,6);
insert into inscription values(72,6);
insert into inscription values(73,6);
insert into inscription values(74,6);
insert into inscription values(75,6);
insert into inscription values(76,6);
insert into inscription values(77,6);
insert into inscription values(78,6);
insert into inscription values(79,6);
insert into inscription values(80,6);
insert into inscription values(2,6);
insert into inscription values(81,6);
insert into inscription values(82,6);
insert into inscription values(83,6);
insert into inscription values(84,6);
insert into inscription values(85,6);
insert into inscription values(86,6);
insert into inscription values(87,6);
insert into inscription values(1,6);

insert into inscription values(71,5);
insert into inscription values(72,5);
insert into inscription values(73,5);
insert into inscription values(74,5);
insert into inscription values(75,5);
insert into inscription values(76,5);
insert into inscription values(77,5);
insert into inscription values(78,5);
insert into inscription values(79,5);
insert into inscription values(80,5);
insert into inscription values(2,5);
insert into inscription values(81,5);
insert into inscription values(82,5);
insert into inscription values(83,5);
insert into inscription values(84,5);
insert into inscription values(85,5);
insert into inscription values(86,5);
insert into inscription values(87,5);
insert into inscription values(1,5);

insert into inscription values(71,4);
insert into inscription values(72,4);
insert into inscription values(73,4);
insert into inscription values(74,4);
insert into inscription values(75,4);
insert into inscription values(76,4);
insert into inscription values(77,4);
insert into inscription values(78,4);
insert into inscription values(79,4);
insert into inscription values(80,4);
insert into inscription values(2,4);
insert into inscription values(81,4);
insert into inscription values(82,4);
insert into inscription values(83,4);
insert into inscription values(84,4);
insert into inscription values(85,4);
insert into inscription values(86,4);
insert into inscription values(87,4);
insert into inscription values(1,4);


insert into inscription values(71,3);
insert into inscription values(72,3);
insert into inscription values(73,3);
insert into inscription values(74,3);
insert into inscription values(75,3);
insert into inscription values(76,3);
insert into inscription values(77,3);
insert into inscription values(78,3);
insert into inscription values(79,3);
insert into inscription values(80,3);
insert into inscription values(2,3);
insert into inscription values(81,3);
insert into inscription values(82,3);
insert into inscription values(83,3);
insert into inscription values(84,3);
insert into inscription values(85,3);
insert into inscription values(86,3);
insert into inscription values(87,3);
insert into inscription values(1,3);


Insert into CONTROLE_CONNAISSANCE (IDCC,IDEC,NUMSESSION,NOTEMAXCC,TYPECC,SSTYPECC,COEFF) values (1,1,1,20,'examen','individuel',5);
Insert into CONTROLE_CONNAISSANCE (IDCC,IDEC,NUMSESSION,NOTEMAXCC,TYPECC,SSTYPECC,COEFF) values (2,5,1,20,'controle continu','equipe',1);



