package com.spring.services;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    private MarqueModelViewRepository repository;

    public List<Model> getAllModel() {
        return modelRepository.findAll();
    }

    public Optional<Model> findByModel(Long idModel) {
        System.out.println("Mety  " + idModel);
        return modelRepository.findById(idModel);
    }

    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

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
