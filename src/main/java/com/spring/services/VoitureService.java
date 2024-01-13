package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.models.Annonce;
import com.spring.models.Voiture;
import com.spring.repository.VoitureRepository;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;

    public Long getLatestId() {
        return voitureRepository.findMaxId();
    }

    public Voiture addVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    public Voiture getVoitureById(Long id) {
        return voitureRepository.findById(id).orElse(null);
    }
}
