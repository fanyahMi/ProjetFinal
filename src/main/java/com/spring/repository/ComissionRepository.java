package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.models.Comission;

@Repository
public interface ComissionRepository extends JpaRepository<Comission, Long> {

}
