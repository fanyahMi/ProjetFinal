package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.repository.ComissionRepository;

@Service
public class ComissionService {
    @Autowired
    private ComissionRepository comissionRepository;

}
