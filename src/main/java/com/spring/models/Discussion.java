package com.spring.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "discussions")
public class Discussion {
    @Id
    private String id;

    private List<String> participants;
    private List<Message> messages;

    public Discussion() {
    }

    public Discussion(String participant1, String participant2, Message message) {
        this.participants = new ArrayList<>();
        this.participants.add(participant1);
        this.participants.add(participant2);
        this.messages = new ArrayList<>();
        this.messages.add(message);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    
}
