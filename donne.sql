-- Insertion de données dans la table "marque"
INSERT INTO marque (marque) VALUES
('Toyota'),
('Honda'),
('Ford');

-- Insertion de données dans la table "categorie"
INSERT INTO categorie (categorie) VALUES
('Sedan'),
('SUV'),
('Truck'),
('Electric'),
('Sports Car');

-- Insertion de données dans la table "model"
INSERT INTO model (marque_id, categorie_id, model) VALUES
(1, 1, 'Camry'),
(1, 2, 'RAV4'),
(2, 1, 'Civic'),
(2, 3, 'CR-V'),
(3, 3, 'F-150'),
(3, 4, 'Mustang');

-- Insertion de données dans la table "anneesortie"
INSERT INTO anneesortie (model_id, annee) VALUES
(1, 2020),
(2, 2019),
(2, 2010),
(3, 2021),
(4, 2022),
(5, 2020),
(6, 2019);
