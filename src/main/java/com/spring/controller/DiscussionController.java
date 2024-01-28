package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.exception.TokenException;
import com.spring.models.Discussion;
import com.spring.models.Message;
import com.spring.services.DiscussionService;
import com.spring.services.TokenService;
import com.spring.token.Token;
import com.spring.utility.Response;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/api/v1/discussions")
@CrossOrigin
public class DiscussionController {

    private final DiscussionService discussionService;
    @Autowired
    private TokenService tokenService;

    @Autowired
    public DiscussionController(DiscussionService discussionService) {
        this.discussionService = discussionService;
    }

    @GetMapping("/prive")
    public ResponseEntity<Response> getPrivateDiscussion(@RequestParam String participant2,
            @RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            Claims claims = tokenService.getClaims(authorizationHeader);
            String userid = claims.get("idUtilisateur").toString();
            response.setStatus_code("200");
            response.setData(discussionService.getPrivateDiscussion(userid, participant2));
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
        // return discussionService.getPrivateDiscussion(user_id, participant2);
    }

    @GetMapping
    public ResponseEntity<Response> getUserDiscussions(@RequestHeader("Authorization") String authorizationHeader) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            response.setStatus_code("200");
            Claims claims = tokenService.getClaims(authorizationHeader);
            String userid = claims.get("idUtilisateur").toString();
            response.setData(discussionService.getUserDiscussions(userid));
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
        // return discussionService.getUserDiscussions(user_id);
    }

    @PostMapping("/message/envoye")
    public ResponseEntity<Response> addMessageToDiscussion(@RequestParam String participant2,
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody Message message) {
        Response response = new Response();
        try {
            tokenService.checkSansRole(authorizationHeader);
            Claims claims = tokenService.getClaims(authorizationHeader);
            String userid = claims.get("idUtilisateur").toString();
            message.setEmetteur(claims.get("nomPrenom").toString());
            discussionService.addMessageToDiscussion(userid, participant2, message);
            response.setStatus_code("200");
            response.setData(discussionService.getPrivateDiscussion(userid, participant2));
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
        // discussionService.addMessageToDiscussion(user_id, participant2, message);
    }
}
