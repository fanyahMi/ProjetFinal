// use vehicule

// Création de la collection "discussions" avec discussion_id comme clé primaire
db.createCollection("discussions", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["participants", "messages"],
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
            required: ["sender", "content", "timestamp"],
            properties: {
              sender: {
                bsonType: "string",
                description: "Nom de l'expéditeur du message"
              },
              content: {
                bsonType: "string",
                description: "Contenu du message"
              },
              timestamp: {
                bsonType: "date",
                description: "Horodatage du message"
              }
            }
          }
        }
      }
    }
  }
})

// Collection info_annonce
db.createCollection("infoannonce", {
  validator: {
      $jsonSchema: {
          bsonType: "object",
          required: ["idannonce", "description", "photo"],
          properties: {
              idannonce: {
                  bsonType: "string",
                  description: "ID de l'annonce"
              },
              description: {
                  bsonType: "string",
                  description: "Description de l'annonce"
              },
              photo: {
                  bsonType: "array",
                  description: "Tableau de chemins de fichiers",
                  items: {
                      bsonType: "string"
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
      required: ["annonce_id", "photos"],
      properties: {
        annonce_id: {
          bsonType: "string",
          description: "id de l'annonce"
        },
        description: {
          bsonType: "string",
          description: "Description de l'annonce"
        },
        photos: {
          bsonType: "array",
          description: "Liste des photos",
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
});


db.infoannonce.insertOne({
  annonce_id: "1",
  description: "Annonce de vente de voiture",
  photos: [
    {
      data: "base64encodedImageData1",
      contentType: "image/jpeg"
    },
    {
      data: "base64encodedImageData2",
      contentType: "image/png"
    }
  ]
});


// Supprimer une collection
db.discussions.drop()
db.infoannonce.drop()


// Avoir tout les discussions
db.discussions.find().pretty()

// Avoir les discussions de 'Alice' et 'Bob'
db.discussions.find({
  participants: { $all: ["Alice", "Bob"] }
})

//  Insérer un document
db.discussions.insertOne({
  participants: ["1:Alice", "2:Bob"],
  messages: [
    {
      sender: "Alice",
      content: "Bonjour Bob",
      timestamp: new Date()
    },
    {
      sender: "Bob",
      content: "salut! quoi de neuf?",
      timestamp: new Date()
    }
  ]
})

db.discussions.insertOne({
  participants: ["1:Alice", "3:John"],
  messages: [
    {
      sender: "Alice",
      content: "Bonjour John",
      timestamp: new Date()
    }
  ]
})

//  Ajouter un nouveau message à la discussion
db.discussions.update(
  { _id: ObjectId('659908a906a0c9f91cc51c94') },
  {
    $push: {
      messages: {
        sender: "Bob",
        content: "Bonne idee!",
        timestamp: new Date()
      }
    }
  }
)

// Supprimer une line avec son id
db.infoannonce.deleteOne({ _id: ObjectId("659be89354293e766909db4b") })
db.discussions.deleteOne({ _id: ObjectId("659a963769888c2e7f30c1b3") })
