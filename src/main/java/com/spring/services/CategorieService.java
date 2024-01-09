package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.models.Categorie;
import com.spring.repository.CategorieRepository;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Optional<Categorie> getCategoryById(Long id) {
        return categorieRepository.findById(id);
    }

    public Categorie saveCategory(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public void deleteCategory(Long id) {
        categorieRepository.deleteById(id);
    }
}