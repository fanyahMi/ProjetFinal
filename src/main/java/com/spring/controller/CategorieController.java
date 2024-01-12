package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.TokenException;
import com.spring.models.Categorie;
import com.spring.services.CategorieService;
import com.spring.services.TokenService;
import com.spring.utility.Response;

@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin
public class CategorieController {
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private TokenService tokenService;

    @GetMapping
    public ResponseEntity<Response> getAllCategories(@RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            response.setStatus_code("200");
            response.setData(categorieService.getAllCategories());
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getCategoryById(@PathVariable Long id,
            @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            response.setStatus_code("200");
            response.setData(categorieService.getCategoryById(id));
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
    }

    @PostMapping
    public ResponseEntity<Response> saveCategory(@RequestBody Categorie categorie,
            @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkRole(authorizationHeader, 10);
            Categorie savedCategorie = categorieService.saveCategory(categorie);
            response.setStatus_code("200");
            response.setData(savedCategorie);
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCategory(@PathVariable Long id,
            @RequestHeader("Authorization") String authorizationHeader) {

        Response response = new Response();
        try {
            tokenService.checkRole(authorizationHeader, 10);
            categorieService.deleteCategory(id);
            response.setStatus_code("200");
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
    }
}