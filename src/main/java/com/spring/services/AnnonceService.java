package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.repository.AnnonceRepository;

@Service
public class AnnonceService {
    @Autowired
    private AnnonceRepository annonceRepository;
}
