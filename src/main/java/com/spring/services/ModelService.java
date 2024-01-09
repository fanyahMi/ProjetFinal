package com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.models.Model;
import com.spring.models.view.MarqueModelView;
import com.spring.repository.MarqueModelViewRepository;
import com.spring.repository.ModelRepository;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

    @Autowired
    private MarqueModelViewRepository repository;

    public List<MarqueModelView> findByAnneeLessThan(Integer annee) {
        return repository.findByAnneeLessThan(annee);
    }

    public List<MarqueModelView> findByAnneeGreaterThanEqual(Integer annee) {
        return repository.findByAnneeGreaterThanEqual(annee);
    }

    public List<MarqueModelView> getAllModelMarque() {
        return repository.findAll();
    }

    public List<MarqueModelView> findByIdCategorie(Long idCategorie) {
        return repository.findByIdCategorie(idCategorie);
    }

    public List<MarqueModelView> findByMarqueId(Long marqueId) {
        return repository.findByMarqueId(marqueId);
    }

    public List<MarqueModelView> findByIdModel(Long idModel) {
        return repository.findByIdModel(idModel);
    }
}
