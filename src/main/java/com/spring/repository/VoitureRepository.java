package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.models.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {

}
