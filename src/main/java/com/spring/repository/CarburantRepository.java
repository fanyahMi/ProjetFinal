package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.models.Carburant;

public interface CarburantRepository extends JpaRepository<Carburant, Long> {

}
