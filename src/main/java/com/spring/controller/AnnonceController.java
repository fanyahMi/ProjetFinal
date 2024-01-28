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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.exception.TokenException;
import com.spring.models.Annonce;
import com.spring.models.Comission;
import com.spring.models.FiltreAnnonce;
import com.spring.models.Photo;
import com.spring.models.Vente;
import com.spring.repository.ComissionRepository;
import com.spring.services.AnnonceService;
import com.spring.services.ComissionService;
import com.spring.services.InfoAnnonceService;
import com.spring.services.VoitureService;
import com.spring.services.PhotoService;
import com.spring.services.view.AnnonceDetailViewService;
import com.spring.services.TokenService;
import com.spring.services.VenteService;

import com.spring.utility.Response;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/api/v1/annonces")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;
    @Autowired
    private VoitureService voitureService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private InfoAnnonceService infoAnnonceService;
    @Autowired
    private AnnonceDetailViewService annonceDetailViewService;
    @Autowired
    private VenteService venteService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ComissionService comisssionservice;
    // Long userIdx = (long) 1;

    @GetMapping
    public ResponseEntity<Response> getAllInfoAnnonces(@RequestHeader("Authorization") String authorizationHeader) {
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

    @GetMapping("filtre")
    public ResponseEntity<Response> getAllInfoAnnonceByFiltre(@RequestBody FiltreAnnonce filtre,
            @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            response.setStatus_code("200");
            response.setData(infoAnnonceService.getInfoAnnonceByFiltre(filtre));
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }

    }

    @GetMapping("/free")
    public ResponseEntity<Response> getAllAnnonces() {
        Response response = new Response();
        try {
            // tokenService.checkSansRole(authorizationHeader);
            response.setStatus_code("200");
            response.setData(infoAnnonceService.getAllInfoAnnonces());
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            response.setStatus_code("500");
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, null);
        }

    }

    @GetMapping("/valide")
    public ResponseEntity<Response> getAllAuthorizedAnnonces(
            @RequestHeader("Authorization") String authorizationHeader) {
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

    @GetMapping("/invendu")
    public ResponseEntity<Response> getAllUnsoldAnnonces(@RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            response.setStatus_code("200");
            response.setData(infoAnnonceService.getAllUnsoldAnnonce());
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
    public ResponseEntity<Response> getAnnonceById(@PathVariable String id,
            @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            response.setStatus_code("200");
            response.setData(infoAnnonceService.getInfoAnnonceByAnnonceId(id));
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
            @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkRole(authorizationHeader, 10);
            Claims claims = tokenService.getClaims(authorizationHeader);
            Long userId = Long.parseLong(claims.get("idUtilisateur").toString());

            annonce.setVendeurId(userId);
            voitureService.addVoiture(annonce.getVoiture());
            Long idVoiture = voitureService.getLatestId(); // Id du dernier voiture ajoutee
            annonce.setVoitureId(idVoiture);
            annonceService.addAnnonce(annonce);
            Long idAnnonce = annonceService.getLatestId(); // Id du dernier annonce ajoutee
            annonce.getInfoAnnonce().setAnnonce_id(idAnnonce.toString());
            annonce.getInfoAnnonce().setAuteur_id(userId.toString());
            annonce.getInfoAnnonce()
                    .setDetailvoitureANDInit(annonceDetailViewService.getAnnonceDetailViewById(idAnnonce).get());

            photoService.uploadAll(annonce.getInfoAnnonce().getPhotos());
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

    @PostMapping("/free")
    public String addAnnonceTest(
            @RequestBody Annonce annonce) {
        if (annonce == null) {
            return "'Annonce is not found'";
        }
        try {
            Long userId = (long) 1;
            annonce.setVendeurId(userId);
            voitureService.addVoiture(annonce.getVoiture());
            Long idVoiture = voitureService.getLatestId(); // Id du dernier voiture ajoutee
            annonce.setVoitureId(idVoiture);
            annonceService.addAnnonce(annonce);
            Long idAnnonce = annonceService.getLatestId(); // Id du dernier annonce ajoutee
            annonce.getInfoAnnonce().setAnnonce_id(idAnnonce.toString());
            annonce.getInfoAnnonce().setAuteur_id(userId.toString());
            annonce.getInfoAnnonce()
                    .setDetailvoitureANDInit(annonceDetailViewService.getAnnonceDetailViewById(idAnnonce).get());

            // Uploader les photos vers firebase et avoir les liens vers mongodb
            photoService.uploadAll(annonce.getInfoAnnonce().getPhotos());

            infoAnnonceService.saveInfoAnnonce(annonce.getInfoAnnonce());

            for (Photo photo : annonce.getInfoAnnonce().getPhotos()) {
                System.out.println("** Photo: " + photo.getData() + " **");
            }

            return "'Annonce is found': " + annonce.getIdAnnonce();
        } catch (Exception e) {
            e.printStackTrace(); // Gérer les erreurs de manière appropriée
            return null; // Vous pouvez également renvoyer une réponse d'erreur appropriée
        }
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        return photoService.upload(multipartFile);
    }

    @PutMapping("/autoriser/{id}")
    public ResponseEntity<Response> authorise(@PathVariable Long id,
            @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkRole(authorizationHeader, 10);
            annonceService.authorise(id);
            infoAnnonceService.updateStatutByAnnonceId(id.toString(), (long) 2);
            response.setStatus_code("200");
            response.setMessage("update réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
    }

    @PostMapping("/vendu")
    public ResponseEntity<Response> vendu(@RequestBody Vente vente,
            @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkRole(authorizationHeader, 10);

            System.out.println("tyfgfsh " + comisssionservice.getComissionlast());
            vente.setTaux_comission(comisssionservice.getComissionlast());
            annonceService.vendu(vente.getAnnonce_id());
            infoAnnonceService.updateStatutByAnnonceId(vente.getAnnonce_id().toString(), (long) 3);
            venteService.newVente(vente);
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
            tokenService.checkRole(authorizationHeader, 10);
            Claims claims = tokenService.getClaims(authorizationHeader);
            Long userId = Long.parseLong(claims.get("idUtilisateur").toString());
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
            tokenService.checkRole(authorizationHeader, 10);
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
            tokenService.checkRole(authorizationHeader, 10);
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
