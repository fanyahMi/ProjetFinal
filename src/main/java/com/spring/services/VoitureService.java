package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.repository.VoitureRepository;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;
}
