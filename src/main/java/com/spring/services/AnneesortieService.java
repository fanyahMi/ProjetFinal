package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.models.Anneesortie;
import com.spring.repository.AnneesortieRepository;

@Service
public class AnneesortieService {

    @Autowired
    private AnneesortieRepository anneeRepository;

    public Anneesortie saveAnneesortie(Anneesortie anneesortie) {
        return anneeRepository.save(anneesortie);
    }

    public void deleteAnnesortie(Long id) {
        anneeRepository.deleteById(id);
    }

}
