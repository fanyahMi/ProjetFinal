package com.spring.repository.view;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.models.view.AnnonceStatView;

public interface AnnonceStatViewRepository extends JpaRepository<AnnonceStatView, Long> {
    List<AnnonceStatView> findByMoisAndAnnee(Long mois, Long annee);
}
