\c commerce;
drop database vehicule;
create database vehicule;
\c vehicule;

create table utilisateur(
    id_utilisateur serial primary key,
    nom varchar(50) not null,
    email varchar(150) not null,
    password varchar(20) not null,
    role varchar(10) not null
);

INSERT INTO utilisateur (nom, email, password, role) VALUES
    ('John Doe', 'haisinjo@example.com', 'hasinjo', 'Admin'),
    ('Alice Smith', 'alice@example.com', 'alicepass', 'User'),
    ('Bob Johnson', 'bob@example.com', '34333', 'User');


create table token(
    id_token serial primary key,
    token text not null,
    cle text not null,
    date_creation date not null,
    date_expiration date not null
); 

create table marque(
    id_marque serial primary key,
    marque varchar(40) not null
);


create table categorie(
    id_categorie serial primary key,
    categorie varchar(70) not null
);

create table model(
    id_model serial primary key,
    marque_id int references marque(id_marque),
    categorie_id int references categorie(id_categorie),
    model varchar(70) not null
);

create table anneesortie(
    id_anneesortie serial primary key,
    model_id int references model(id_model),
    annee int not null
);




create or replace view v_marque_model as 
select 
    mo.id_model, mo.marque_id, m.marque, an.id_anneesortie, an.annee,
    ca.id_categorie, ca.categorie, mo.model
from marque m
join model mo on mo.marque_id = m.id_marque
join anneesortie an  on an.model_id = mo.id_model
join categorie ca on ca.id_categorie =  mo.categorie_id;


