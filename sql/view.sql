create or replace view v_marque_model as 
select 
    mo.id_model, mo.marque_id, m.marque, an.id_anneesortie, an.annee,
    ca.id_categorie, ca.categorie, mo.model
from marque m
join model mo on mo.marque_id = m.id_marque
join anneesortie an  on an.model_id = mo.id_model
join categorie ca on ca.id_categorie =  mo.categorie_id;
