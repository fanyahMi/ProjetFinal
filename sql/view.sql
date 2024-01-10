create or replace view v_marque_model as 
select 
    mo.id_model, mo.marque_id, m.marque, an.id_anneesortie, an.annee,
    ca.id_categorie, ca.categorie, mo.model
from marque m
join model mo on mo.marque_id = m.id_marque
join anneesortie an  on an.model_id = mo.id_model
join categorie ca on ca.id_categorie =  mo.categorie_id;

CREATE VIEW v_model_details AS
SELECT
    ma.id_marque,
    ma.marque,
    m.id_model,
    m.model,
    c.id_categorie,
    c.categorie
FROM
    model m
    JOIN marque ma ON m.marque_id = ma.id_marque
    JOIN categorie c ON m.categorie_id = c.id_categorie
    order by ma.id_marque, m.id_model, c.id_categorie;

create view v_model_annee as 
select 
    m.id_marque,
    m.marque,
    m.id_model,
    m.model,
    m.id_categorie,
    m.categorie,
    an.id_anneesortie,
    an.annee 
from 
    v_model_details m
    join anneesortie an on an.model_id = m.id_model 
    order by m.id_marque, m.id_model, m.id_categorie, an.id_anneesortie; 

