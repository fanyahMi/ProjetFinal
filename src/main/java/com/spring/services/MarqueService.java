package com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.models.Marque;
import com.spring.repository.MarqueRepository;

@Service
public class MarqueService {

    @Autowired
    private MarqueRepository marqueRepository;

    public List<Marque> getAllMarques() {
        return marqueRepository.findAll();
    }

    public Marque getMarqueById(Long id) {
        return marqueRepository.findById(id).orElse(null);
    }

    public Marque addMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    public Marque updateMarque(Long id, Marque newMarque) {
        return marqueRepository.findById(id)
                .map(marque -> {
                    marque.setMarque(newMarque.getMarque());
                    return marqueRepository.save(marque);
                })
                .orElse(null);
    }

    public void deleteMarque(Long id) {
        marqueRepository.deleteById(id);
    }
}
