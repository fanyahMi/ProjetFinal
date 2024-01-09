package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.models.Comission;
import com.spring.repository.ComissionRepository;

@Service
public class ComissionService {

    private final ComissionRepository comissionRepository;

    @Autowired
    public ComissionService(ComissionRepository comissionRepository) {
        this.comissionRepository = comissionRepository;
    }

    public Comission saveComission(Comission comission) {
        return comissionRepository.save(comission);
    }
}
