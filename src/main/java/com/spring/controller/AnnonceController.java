package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.exception.TokenException;
import com.spring.models.Annonce;
import com.spring.models.InfoAnnonce;
import com.spring.models.Photo;
import com.spring.services.AnnonceService;
import com.spring.services.InfoAnnonceService;
import com.spring.services.VoitureService;
import com.spring.services.view.AnnonceDetailViewService;
import com.spring.services.TokenService;
import org.springframework.web.multipart.MultipartFile;

import com.spring.utility.Response;

@RestController
@RequestMapping("/api/v1/annonces")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;
    @Autowired
    private VoitureService voitureService;
    @Autowired
    private InfoAnnonceService infoAnnonceService;
    @Autowired
    private AnnonceDetailViewService annonceDetailViewService;
    @Autowired
    private TokenService tokenService;

    Long userId = (long) 1;

    @GetMapping
    public ResponseEntity<Response> getAllAnnonces(@RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            response.setStatus_code("200");
            response.setData(infoAnnonceService.getAllInfoAnnonces());
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }

    }

    @GetMapping("valide")
    public ResponseEntity<Response> getAllAuthorizedAnnonces(@RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            response.setStatus_code("200");
            response.setData(infoAnnonceService.getAllAuthorizedAnnonces());
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }

    }

    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<Response> getUtilisateurAnnonces(@PathVariable Long id,
        @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            response.setStatus_code("200");
            response.setData(infoAnnonceService.getAllAuteurAnnonces(id.toString()));
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }

    }

    @GetMapping("/favoris/{id}")
    public ResponseEntity<Response> getUtilisateurFavorisAnnonces(@PathVariable Long id,
        @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            response.setStatus_code("200");
            response.setData(infoAnnonceService.getAllAuteurFavoris(id.toString()));
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getAnnonceById(@PathVariable Long id,
            @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            // Initialiser les donnes de l'annonce
            Annonce annonce = annonceService.getAnnonceById(id);
            annonce.setVoiture(voitureService.getVoitureById(annonce.getVoitureId()));
            // annonce.setInfoAnnonce(infoAnnonceService.getInfoAnnonceByAnnonceId(id.toString()));

            tokenService.checkSansRole(authorizationHeader);
            response.setStatus_code("200");
            response.setData(annonce);
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
    }

    @PostMapping
    public ResponseEntity<Response> addAnnonce(@RequestBody Annonce annonce, 
            @RequestHeader("Authorization") String authorizationHeader
            ) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);

            annonce.setVendeurId(userId);
            voitureService.addVoiture(annonce.getVoiture());
            Long idVoiture = voitureService.getLatestId(); // Id du dernier voiture ajoutee
            annonce.setVoitureId(idVoiture);
            annonceService.addAnnonce(annonce);
            Long idAnnonce = annonceService.getLatestId(); // Id du dernier annonce ajoutee
            annonce.getInfoAnnonce().setAnnonce_id(idAnnonce.toString());
            annonce.getInfoAnnonce().setAuteur_id(userId.toString());
            annonce.getInfoAnnonce().setDetailvoitureANDInit(annonceDetailViewService.getAnnonceDetailViewById(idAnnonce).get());
            infoAnnonceService.saveInfoAnnonce(annonce.getInfoAnnonce());
            
            response.setStatus_code("200");
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
    }

    // @PostMapping("/add")
    // public InfoAnnonce addAnnonceTest(
    //     @RequestBody Annonce annonce) {
    //     try {
    //         annonce.setVendeurId(userId);
    //         voitureService.addVoiture(annonce.getVoiture());
    //         annonce.setVoitureId(voitureService.getLatestId());
    //         annonceService.addAnnonce(annonce);
    //         annonce.getInfoAnnonce().setAnnonce_id(annonceService.getLatestId().toString());
            
    //         return infoAnnonceService.saveInfoAnnonce(annonce.getInfoAnnonce());
    //     } catch (Exception e) {
    //         e.printStackTrace(); // Gérer les erreurs de manière appropriée
    //         return null; // Vous pouvez également renvoyer une réponse d'erreur appropriée
    //     }
    // }

    @PostMapping("/upload")
    public InfoAnnonce uploadImages(@RequestParam("file") MultipartFile file) {
        try {
            // Créer une instance de Photo et ajouter à la liste
            Photo photo = new Photo(file);

            // Créer une instance d'InfoAnnonce avec les paramètres fournis
            InfoAnnonce infoAnnonce = new InfoAnnonce("1", "Voiture a vendre ici!");

            // Ajouter la photo à la liste de photos de l'infoAnnonce
            infoAnnonce.getPhotos().add(photo);

            // Sauvegarder dans la base de données
            return infoAnnonceService.saveInfoAnnonce(infoAnnonce);
        } catch (Exception e) {
            e.printStackTrace(); // Gérer les erreurs de manière appropriée
            return null; // Vous pouvez également renvoyer une réponse d'erreur appropriée
        }
    }

    @PutMapping("/autoriser/{id}")
    public ResponseEntity<Response> authorise(@PathVariable Long id,
            @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            annonceService.authorise(id);
            infoAnnonceService.updateStatutByAnnonceId(id.toString());
            response.setStatus_code("200");
            response.setMessage("update réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
    }

    @PutMapping("/favoris/{id}")
    public ResponseEntity<Response> addToFavoris(@PathVariable Long id,
            @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            annonceService.authorise(id);
            infoAnnonceService.addToFavoris(id.toString(), userId.toString());
            response.setStatus_code("200");
            response.setMessage("update réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateAnnonce(@PathVariable Long id,
            @RequestBody Annonce newAnnonce,
            @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            annonceService.updateAnnonce(newAnnonce);
            response.setStatus_code("200");
            response.setMessage("update réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteAnnonce(@PathVariable Long id,
            @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            annonceService.deleteAnnonce(id);
            response.setStatus_code("200");
            response.setMessage("Suppression réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
    }
}
