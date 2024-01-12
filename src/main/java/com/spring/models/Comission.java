package com.spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Comission;
    private double taux;

    public Long getId_Comission() {
        return id_Comission;
    }

    public void setId_Comission(Long id_Comission) {
        this.id_Comission = id_Comission;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

}
