package com.spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComission;

    private Double taux;

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

}
