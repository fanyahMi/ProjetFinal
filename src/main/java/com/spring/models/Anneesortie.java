package com.spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Anneesortie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_anneesortie;
    private Long model_id;
    private int annee;

    public Long getId_anneesortie() {
        return id_anneesortie;
    }

    public void setId_anneesortie(Long id_anneesortie) {
        this.id_anneesortie = id_anneesortie;
    }

    public Long getModel_id() {
        return model_id;
    }

    public void setModel_id(Long model_id) {
        this.model_id = model_id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

}
