/* Create BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK*/
create database daaw;

create table responsable(
    fname varchar(100),
    lname varchar(100),
    pswrd varchar(50)
);

insert into responsable values ('laid','seghir','110863');

create table ViceDoyen(
    fname varchar(100),
    lname varchar(100),
    pswrd varchar(50)
);

insert into ViceDoyen values('hocine','chabane','110863');

create table student(
    id int(11) auto_increment,
    fname varchar(100),
    lname varchar(100),
    Bd_date DATE,
    Bd_place varchar(50),
    email varchar(100),
    pswrd varchar(50),
    specialite varchar(50),
    cv mediumblob,
    moy float(11),
    nbr_red int(11),
    nbr_prg int(11),
    nbr_rat int(11),
    master1 varchar(100),
    master2 varchar(100),
    master3 varchar(100),
    primary key(id,email)
);


create table deleted_student(
    id int(11) auto_increment,
    fname varchar(100),
    lname varchar(100),
    Bd_date DATE,
    Bd_place varchar(50),
    email varchar(100),
    pswrd varchar(50),
    specialite varchar(50),
    moy float(11),
    nbr_red int(11),
    nbr_prg int(11),
    nbr_rat int(11),
    primary key(id,email)
);

create table accepted_student(
    id int(11) auto_increment,
    fname varchar(100),
    lname varchar(100),
    Bd_date DATE,
    Bd_place varchar(50),
    email varchar(100),
    pswrd varchar(50),
    specialite varchar(50),
    moy float(11),
    nbr_red int(11),
    nbr_prg int(11),
    nbr_rat int(11),
    primary key(id,email)
);

create table Registred_students(
    id int(11) auto_increment primary key,
    fname varchar(100),
    lname varchar(100),
    email varchar(100),
    master_choosed varchar(100)
);


                                                                        

create table universite(
    id_univ int(5) auto_increment primary key,
    nom_univ varchar(100)
    );

    insert into universite(nom_univ) values('Constantine 2'),('Constantine 3');


create table filiere(
    id_fil int(5) auto_increment primary key, 
    id_univ_f int(5) not null,
    nom_fil varchar(100)
);

insert into filiere(id_univ_f,nom_fil) values(1,'Informatique'),(1,'Bibliotheque'),(2,'Medecine'),(2,'Pharmacie');

alter table filiere add constraint fk_id_univ foreign key (id_univ_f) references universite(id_univ);

create table specialite(
    id_spec int(5) auto_increment primary key,
    id_fil_s int(5) not null,
    nom_spec varchar(100),
    nbr_places int(5)
);

alter table specialite add constraint fk_id_fil foreign key(id_fil_s) references filiere(id_fil);

insert into specialite(id_fil_s,nom_spec,nbr_places) values (1,'GL',5),(1,'SCI',5),(2,'Archive',5),(3,'Cardiologie',5),(3,'Pnemologie',5),(4,'Laboratoire de recherche',5);



DELIMITER |
create Trigger after_insert_Trigger after insert 
on registred_students for each row
begin
	update specialite 
	set nbr_places = nbr_places - 1
	where nom_spec = new.master_choosed;
END |
DELIMITER ;


DELIMITER |
create Trigger before_delete_trigger before delete 
on registred_students for each row
begin
    update specialite
    set nbr_places = nbr_places + 1
    where nom_spec = old.master_choosed;
END |
DELIMITER








