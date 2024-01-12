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
import com.spring.utility.Response;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discussions")
public class DiscussionController {

    private final DiscussionService discussionService;
    @Autowired
    private TokenService tokenService;
    String user_id = "1:Alice";

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
            response.setStatus_code("200");
            response.setData(discussionService.getPrivateDiscussion(user_id, participant2));
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
            response.setData(discussionService.getUserDiscussions(user_id));
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
            discussionService.addMessageToDiscussion(user_id, participant2, message);
            response.setStatus_code("200");
            response.setData(discussionService.getPrivateDiscussion(user_id, participant2));
            response.setMessage("réussi");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (TokenException e) {
            response.setStatus_code(e.getStatus_code());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
        // discussionService.addMessageToDiscussion(user_id, participant2, message);
    }

    // @GetMapping
    // public List<Discussion> getAllDiscussions() {
    //     return discussionService.getAllDiscussions();
    // }

    // @GetMapping("/{id}")
    // public Discussion getDiscussionById(@PathVariable String id) {
    //     return discussionService.getDiscussionById(id);
    // }

    // @PostMapping
    // public Discussion createDiscussion(@RequestBody Discussion discussion) {
    //     return discussionService.saveDiscussion(discussion);
    // }

    // @DeleteMapping("/{id}")
    // public void deleteDiscussion(@PathVariable String id) {
    //     discussionService.deleteDiscussion(id);
    // }
}

