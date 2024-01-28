package com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.models.Annonce;
import com.spring.repository.AnnonceRepository;

@Service
public class AnnonceService {
    @Autowired
    private AnnonceRepository annonceRepository;

    public Long getLatestId() {
        return annonceRepository.findMaxId();
    }

    public void authorise(Long id) {
        annonceRepository.authoriser(2, id);
    }

    public void vendu(Long id) {
        annonceRepository.vendu(3, id);
    }

    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    public List<Annonce> getAllByVendeurId(Long id) {
        return annonceRepository.findAllByVendeurId(id);
    }

    public Annonce getAnnonceById(Long id) {
        return annonceRepository.findById(id).orElse(null);
    }

    public Annonce addAnnonce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    public Annonce updateAnnonce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    public void deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }
}
