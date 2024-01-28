package com.spring;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

// import com.google.auth.oauth2.GoogleCredentials;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
	 * @Bean
	 * FirebaseMessaging firebaseMessaging() throws IOException {
	 * GoogleCredentials googleCredentials = GoogleCredentials.fromStream(
	 * new ClassPathResource("vaikaokazy-c4d274345041.json").getInputStream());
	 * FirebaseOptions firebaseOptions = FirebaseOptions
	 * .builder()
	 * .setCredentials(googleCredentials)
	 * .build();
	 * FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions,
	 * "testfaraggggny2jh24d");
	 * return FirebaseMessaging.getInstance(app);
	 * }
	 */
}
