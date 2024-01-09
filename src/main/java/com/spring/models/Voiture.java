package com.spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoiture;
    private Long modelId;
    private String matricule;
    private Long utilisateurId;
    private double kilometrage;
    private Long modelcarburantId;
    private Long anneesortieId;

    public Long getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(Long idVoiture) {
        this.idVoiture = idVoiture;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Long getModelcarburantId() {
        return modelcarburantId;
    }

    public void setModelcarburantId(Long modelcarburantId) {
        this.modelcarburantId = modelcarburantId;
    }

    public Long getAnneesortieId() {
        return anneesortieId;
    }

    public void setAnneesortieId(Long anneesortieId) {
        this.anneesortieId = anneesortieId;
    }

}
