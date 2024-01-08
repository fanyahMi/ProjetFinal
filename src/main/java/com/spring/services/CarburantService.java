package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.repository.CarburantRepository;

@Service
public class CarburantService {
    @Autowired
    private CarburantRepository carburantrepository;
}
