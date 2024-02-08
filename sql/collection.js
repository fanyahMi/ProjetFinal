// use vehicule

// Création de la collection "discussions" avec discussion_id comme clé primaire
db.createCollection("discussions", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["participants"],
      properties: {
        participants: {
          bsonType: "array",
          items: {
            bsonType: "string",
            description: "Noms des participants"
          }
        },
        messages: {
          bsonType: "array",
          items: {
            bsonType: "object",
            required: ["emetteur", "contenu", "date"],
            properties: {
              emetteur: {
                bsonType: "string",
                description: "Nom de l'expéditeur du message"
              },
              contenu: {
                bsonType: "string",
                description: "Contenu du message"
              },
              date: {
                bsonType: "date",
                description: "Horodatage du message"
              }
            }
          }
        }
      }
    }
  }
});

db.createCollection("infoannonce", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["annonce_id", "auteur_id", "detailvoiture", "description"],
      properties: {
        annonce_id: {
          bsonType: "string",
          description: "id de l'annonce"
        },
        auteur_id: {
          bsonType: "string",
          description: "id de l'auteur"
        },
        auteur: {
          bsonType: "string",
          description: "auteur de l'annonce"
        },
        lieu: {
          bsonType: "string",
          description: "lieu de l'annonce"
        },
        prix_vente: {
          bsonType: "long",
          description: "prix de vente"
        },
        statut: {
          bsonType: "long",
          description: "statut de l'annonce"
        },
        date_annonce: {
          bsonType: "date",
          description: "date de l'annonce"
        },
        detailvoiture: {
          bsonType: "object",
          required: ["marque"],
          properties: {
            matricule: {
              bsonType: "string",
              description: "matricule"
            },
            kilometrage: {
              bsonType: "long",
              description: "kilometrage"
            },
            marque: {
              bsonType: "string",
              description: "marque"
            },
            categorie: {
              bsonType: "string",
              description: "categorie"
            },
            annee: {
              bsonType: "long",
              description: "annee"
            },
            carburant: {
              bsonType: "string",
              description: "carburant"
            }
          }
        },
        description: {
          bsonType: "string",
          description: "Description de l'annonce"
        },
        proprietes: {
          bsonType: "array",
          items: {
            bsonType: "object",
            required: ["titre", "description"],
            properties: {
              titre: {
                bsonType: "string",
                description: "propriete titre"
              },
              description: {
                bsonType: "string",
                description: "propriete description"
              }
            }
          }
        },
        favoris: {
          bsonType: "array",
          items: {
            bsonType: "string",
            description: "id_utilisateur"
          }
        },
        photos: {
          bsonType: "array",
          items: {
            bsonType: "object",
            required: ["data", "contentType"],
            properties: {
              data: {
                bsonType: "string",
                description: "Données binaires de l'image encodées en base64"
              },
              contentType: {
                bsonType: "string",
                description: "Type MIME de l'image (par exemple, 'image/jpeg')"
              }
            }
          }
        }
      }
    }
  }
})


//  Insérer dans discussion
db.discussions.insertOne({
  participants: ["1", "2"],
  messages: [
    {
      emetteur: "Alice",
      contenu: "Bonjour Bob",
      date: new Date()
    },
    {
      emetteur: "Bob",
      contenu: "salut! quoi de neuf?",
      date: new Date()
    }
  ]
});

db.discussions.insertOne({
  participants: ["1", "3"],
  messages: [
    {
      emetteur: "Alice",
      contenu: "Bonjour John",
      date: new Date()
    }
  ]
})


// Insérer dans infoannonce
db.infoannonce.insertOne({
  annonce_id: "1",
  auteur_id: "2",
  auteur: "RANDRIA Malala",
  lieu: "Antananarivo",
  statut: NumberLong(2),
  prix_vente: NumberLong(75000000),
  date_annonce: ISODate('2024-01-10T12:30:00.668Z'),
  detailvoiture: {
    matricule: "ABC123",
    kilometrage: NumberLong(5000),
    marque: "Mazda",
    categorie: "SUV",
    annee: NumberLong(2020),
    carburant: "Essence"
  },
  description: "Explorez le monde avec cette élégante Mazda CX3 qui vous emmènera vers de nouvelles aventures!",
  proprietes: [
    {
      titre: "Confort",
      description: "Intérieur spacieux avec sièges ajustables et climatisation"
    },
    {
      titre: "Technologie",
      description: "Écran tactile intuitif avec système de navigation embarqué"
    }
  ],
  photos: [
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/04e0e1be-f60f-4cfc-b199-866365f3aaa5.jpg?alt=media",
      contentType: "image/jpeg"
    },
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/95b2588c-e6f8-4551-81c7-eafc0df962bc.jpg?alt=media",
      contentType: "image/jpeg"
    }
  ]
});

db.infoannonce.insertOne({
  annonce_id: "2",
  auteur_id: "3",
  auteur: "RAKOTO Nirina",
  lieu: "Antsirabe",
  statut: NumberLong(2),
  prix_vente: NumberLong(120000000),
  date_annonce: ISODate('2024-01-12T15:55:12.668Z'),
  detailvoiture: {
    matricule: "DEF456",
    kilometrage: NumberLong(7500),
    marque: "Audi",
    categorie: "SUV",
    annee: NumberLong(2020),
    carburant: "Diesel"
  },
  description: "Voyagez avec style dans cette Audi Q8 haut de gamme et profitez d'une conduite exceptionnelle!",
  proprietes: [
    {
      titre: "Performances",
      description: "Moteur diesel puissant avec transmission intégrale quattro"
    },
    {
      titre: "Confort",
      description: "Intérieur luxueux avec sièges en cuir chauffants et climatisation automatique"
    }
  ],
  photos: [
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/df997a3c-d3c9-496e-990d-adf04b29d596.jpg?alt=media",
      contentType: "image/jpeg"
    },
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/b9020d3f-30c1-4c26-8ede-73bd872d5777.jpeg?alt=media",
      contentType: "image/jpeg"
    }
  ]
});

db.infoannonce.insertOne({
  annonce_id: "3",
  auteur_id: "5",
  auteur: "RAZAFY Manantsoa",
  lieu: "Fianarantsoa",
  statut: NumberLong(2),
  prix_vente: NumberLong(90000000),
  date_annonce: ISODate('2024-01-15T09:15:32.668Z'),
  detailvoiture: {
    matricule: "GHI789",
    kilometrage: NumberLong(15000),
    marque: "Porsche",
    categorie: "Cayenne Turbo GT",
    annee: NumberLong(2023),
    carburant: "Essence"
  },
  description: "Faites l'expérience de la puissance brute dans ce Porsche Cayenne Turbo GT et soyez prêt pour l'excitation!",
  proprietes: [
    {
      titre: "Sportivité",
      description: "Design agressif avec des performances de supercar"
    },
    {
      titre: "Luxure",
      description: "Intérieur en alcantara avec finitions en fibre de carbone"
    }
  ],
  photos: [
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/60d2eeed-4846-4bd4-be9b-cef3f111504f.jpg?alt=media",
      contentType: "image/jpeg"
    },
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/fd6c7dce-0195-4a11-a5d7-e9f9f95de532.jpg?alt=media",
      contentType: "image/jpeg"
    }
  ]
});

db.infoannonce.insertOne({
  annonce_id: "4",
  auteur_id: "5",
  auteur: "RAZAFY Manantsoa",
  lieu: "Antsirabe",
  statut: NumberLong(2),
  prix_vente: NumberLong(68000000),
  date_annonce: ISODate('2024-01-25T19:00:45.668Z'),
  detailvoiture: {
    matricule: "JKL012",
    kilometrage: NumberLong(3000),
    marque: "Ford",
    categorie: "Camionnette",
    annee: NumberLong(2021),
    carburant: "Hybride"
  },
  description: "Dominez les routes avec ce Ford Ranger robuste et pratique, idéal pour les aventures en plein air!",
  proprietes: [
    {
      titre: "Polyvalence",
      description: "Plateforme de chargement spacieuse et capacité de remorquage impressionnante"
    },
    {
      titre: "Confort",
      description: "Intérieur ergonomique avec sièges confortables et espace de rangement"
    }
  ],
  photos: [
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/6f98f0ce-e734-4948-8c15-cbf42b5548a1.jpg?alt=media",
      contentType: "image/jpeg"
    },
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/9e59b534-fe3e-40da-ae75-e898111bff85.jpeg?alt=media",
      contentType: "image/jpeg"
    }
  ]
});

db.infoannonce.insertOne({
  annonce_id: "5",
  auteur_id: "3",
  auteur: "RAKOTO Nirina",
  lieu: "Fianarantsoa",
  statut: NumberLong(2),
  prix_vente: NumberLong(100000000),
  date_annonce: ISODate('2024-01-18T14:20:18.668Z'),
  detailvoiture: {
    matricule: "MNO345",
    kilometrage: NumberLong(6000),
    marque: "Mazda",
    categorie: "Camionnette",
    annee: NumberLong(2023),
    carburant: "Essence"
  },
  description: "Découvrez l'aventure sans limites avec cette Mazda BT-50 fiable et robuste, prête pour toutes les conditions!",
  proprietes: [
    {
      titre: "Capacité",
      description: "Chargement lourd et capacité de remorquage"
    },
    {
      titre: "Confort",
      description: "Intérieur spacieux avec sièges réglables et système audio premium"
    }
  ],
  photos: [
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/1bea87d6-a217-4683-8d15-7d0763a85c39.jpg?alt=media",
      contentType: "image/jpeg"
    },
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/e956d187-3b85-4b2c-a020-60f7cc4b79a9.jpg?alt=media",
      contentType: "image/jpeg"
    }
  ]
});

db.infoannonce.insertOne({
  annonce_id: "6",
  auteur_id: "2",
  auteur: "RANDRIA Malala",
  lieu: "Antananarivo",
  statut: NumberLong(2),
  prix_vente: NumberLong(110500000),
  date_annonce: ISODate('2024-01-10T12:30:42.668Z'),
  detailvoiture: {
    matricule: "PQR678",
    kilometrage: NumberLong(12500),
    marque: "Range Rover",
    categorie: "SUV",
    annee: NumberLong(2019),
    carburant: "Essence"
  },
  description: "Vivez le luxe ultime avec cette Range Rover SUV, alliant élégance et performance pour une expérience de conduite inégalée!",
  proprietes: [
    {
      titre: "Élégance",
      description: "Design extérieur distinctif avec finitions haut de gamme"
    },
    {
      titre: "Technologie",
      description: "Système d'infodivertissement avancé avec écran tactile"
    }
  ],
  photos: [
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/9fc67c7f-f46e-49a9-8e32-a8e0d040ba6c.jpg?alt=media",
      contentType: "image/jpeg"
    },
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/5448493a-d53d-46ef-ac03-449566052edb.jpg?alt=media",
      contentType: "image/jpeg"
    }
  ]
});

db.infoannonce.insertOne({
  annonce_id: "7",
  auteur_id: "3",
  auteur: "RAKOTO Nirina",
  lieu: "Toamasina",
  statut: NumberLong(2),
  prix_vente: NumberLong(60000000),
  date_annonce: ISODate('2024-01-12T15:45:15.668Z'),
  detailvoiture: {
    matricule: "MAD005",
    kilometrage: NumberLong(7000),
    marque: "Toyota",
    categorie: "SUV",
    annee: NumberLong(2020),
    carburant: "Diesel"
  },
  description: "Découvrez la polyvalence et l'efficacité de cette Toyota RAV-4 hybride, parfaite pour les aventures urbaines et hors route!",
  proprietes: [
    {
      titre: "Polyvalence",
      description: "Conception tout-terrain avec système de traction intégrale"
    },
    {
      titre: "Économie",
      description: "Consommation de carburant réduite grâce à la technologie hybride"
    }
  ],
  photos: [
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/07ab8265-7a29-4b34-a80c-985a43e163be.jpg?alt=media",
      contentType: "image/jpeg"
    },
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/eb4515b1-e8a4-41ab-9eba-c8f146c9721c.webp?alt=media",
      contentType: "image/jpeg"
    }
  ]
});

db.infoannonce.insertOne({
  annonce_id: "8",
  auteur_id: "4",
  auteur: "RAHARY Manitra",
  lieu: "Antananarivo",
  statut: NumberLong(1),
  prix_vente: NumberLong(65000000),
  date_annonce: ISODate('2024-01-15T14:20:12.668Z'),
  detailvoiture: {
    matricule: "YZA567",
    kilometrage: NumberLong(3450),
    marque: "BMW",
    categorie: "Berline",
    annee: NumberLong(2021),
    carburant: "Electrique"
  },
  description: "Faites l'expérience de l'innovation avec la BMW i5, une voiture électrique de pointe.",
  proprietes: [
    {
      titre: "Technologie",
      description: "Système de conduite semi-autonome BMW Driving Assistant"
    },
    {
      titre: "Performance",
      description: "Autonomie de conduite électrique de 400 km"
    }
  ],
  photos: [
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/8cc90d72-e1e2-4ce4-9b2c-bd14287948f2.jpg?alt=media",
      contentType: "image/jpeg"
    },
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/270b8dbe-d4a2-4dd9-a9e4-c85603846cb1.jpg?alt=media",
      contentType: "image/jpeg"
    }
  ]
});

db.infoannonce.insertOne({
  annonce_id: "9",
  auteur_id: "4",
  auteur: "RAHARY Manitra",
  lieu: "Fianarantsoa",
  statut: NumberLong(1),
  prix_vente: NumberLong(58000000),
  date_annonce: ISODate('2024-01-18T19:09:35.668Z'),
  detailvoiture: {
    matricule: "VWX234",
    kilometrage: NumberLong(25000),
    marque: "Subaru",
    categorie: "Berlin",
    annee: NumberLong(2023),
    carburant: "Essence"
  },
  description: "Vivez l'aventure avec style dans ce Subaru berlin.",
  proprietes: [
    {
      titre: "Performances",
      description: "Traction intégrale symétrique pour une adhérence optimale"
    },
    {
      titre: "Confort",
      description: "Sièges chauffants en cuir et système audio haut de gamme"
    }
  ],
  photos: [
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/0784ee58-7556-438e-9958-6286b18ebd19.jpg?alt=media",
      contentType: "image/jpeg"
    },
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/15fd4ac9-3451-4c3a-a463-fdf51cafe2e8.jpg?alt=media",
      contentType: "image/jpeg"
    }
  ]
});

db.infoannonce.insertOne({
  annonce_id: "10",
  auteur_id: "5",
  auteur: "RAZAFY Manantsoa",
  lieu: "Antananarivo",
  statut: NumberLong(1),
  prix_vente: NumberLong(85000000),
  date_annonce: ISODate('2024-01-20T09:15:49.668Z'),
  detailvoiture: {
    matricule: "BCD789",
    kilometrage: NumberLong(1000),
    marque: "Toyota",
    categorie: "SUV",
    annee: NumberLong(2021),
    carburant: "Hybride"
  },
  description: "Découvrez le confort et la puissance ultime avec ce Toyota Fortuner.",
  proprietes: [
    {
      titre: "Performances",
      description: "Moteur V8 bi-turbo de 550 chevaux"
    },
    {
      titre: "Confort",
      description: "Intérieur en cuir de haute qualité avec sièges massants"
    }
  ],
  photos: [
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/13221555-da78-4275-8478-61bc3bea3e0e.jpeg?alt=media",
      contentType: "image/jpeg"
    },
    {
      data: "https://firebasestorage.googleapis.com/v0/b/istock-3c7b6.appspot.com/o/37ff8133-91a7-462a-b700-32fa0ac19f48.jpg?alt=media",
      contentType: "image/jpeg"
    }
  ]
});
