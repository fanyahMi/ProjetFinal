package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.models.Discussion;
import com.spring.models.Message;
import com.spring.repository.DiscussionRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;

    @Autowired
    public DiscussionService(DiscussionRepository discussionRepository) {
        this.discussionRepository = discussionRepository;
    }

    public List<Discussion> getAllDiscussions() {
        return discussionRepository.findAll();
    }

    public Discussion getDiscussionById(String id) {
        return discussionRepository.findById(id).orElse(null);
    }

    public Discussion saveDiscussion(Discussion discussion) {
        return discussionRepository.save(discussion);
    }

    public void deleteDiscussion(String id) {
        discussionRepository.deleteById(id);
    }

    public List<Discussion> getUserDiscussions(String participant) {
        Sort sort = Sort.by(Sort.Order.desc("messages.date"));
        return discussionRepository.findUserDiscussions(participant, sort);
    }

    public List<Discussion> getPrivateDiscussion(String participant1, String participant2) {
        return discussionRepository.findPrivateDiscussion(participant1, participant2);
    }

    public void addMessageToDiscussion(String participant1, String participant2, Message message) {
        List<Discussion> discussions = discussionRepository.findPrivateDiscussion(participant1, participant2);
        
        if (discussions.size() != 0) {
            Discussion discussion = discussionRepository.findPrivateDiscussion(participant1, participant2).get(0);
            discussion.getMessages().add(message);
            discussionRepository.save(discussion);
            System.out.println("** Discussion found **");
        } else {
            Discussion newDiscussion = new Discussion(participant1, participant2, message);
            discussionRepository.save(newDiscussion);
            System.out.println("** Discussion not found: " + participant1 + "|" + participant2);
        }
    }
}
