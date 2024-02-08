package com.spring.services.firebase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.models.notification.NotificationMessage;

@Service
public class FirebaseMessagingService {

        /*
         * @Autowired
         * private FirebaseMessaging firebaseMessaging;
         * 
         * public String sendNotification(NotificationMessage notificationMessage)
         * throws FirebaseMessagingException {
         * 
         * Notification notification = Notification
         * .builder()
         * .setTitle(notificationMessage.getTitle())
         * .setBody(notificationMessage.getBody())
         * .build();
         * 
         * Message message = Message
         * .builder()
         * .setToken(notificationMessage.getRecipientToken())
         * .setNotification(notification)
         * .putAllData(notificationMessage.getData())
         * .build();
         * 
         * return firebaseMessaging.send(message);
         * }
         */
}
