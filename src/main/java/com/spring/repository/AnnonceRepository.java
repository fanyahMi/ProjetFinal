package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.models.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

}
