package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.models.view.MarqueModelView;

public interface MarqueModelViewRepository extends JpaRepository<MarqueModelView, Long> {

    List<MarqueModelView> findByAnneeLessThan(Integer annee);

    List<MarqueModelView> findByAnneeGreaterThanEqual(Integer annee);

    List<MarqueModelView> findByIdCategorie(Long idCategorie);

    List<MarqueModelView> findByMarqueId(Long marqueId);

    List<MarqueModelView> findByIdModel(Long idModel);
}
