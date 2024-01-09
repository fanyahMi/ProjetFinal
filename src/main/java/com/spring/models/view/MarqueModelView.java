package com.spring.models.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "v_marque_model")
public class MarqueModelView {

    @Id
    @Column(name = "id_model")
    private Long idModel;

    @Column(name = "marque_id")
    private Long marqueId;

    @Column(name = "marque")
    private String marque;

    @Column(name = "id_anneesortie")
    private Long idAnneeSortie;

    @Column(name = "annee")
    private Integer annee;

    @Column(name = "id_categorie")
    private Long idCategorie;

    @Column(name = "categorie")
    private String categorie;

    @Column(name = "model")
    private String model;

    public Long getIdModel() {
        return idModel;
    }

    public void setIdModel(Long idModel) {
        this.idModel = idModel;
    }

    public Long getMarqueId() {
        return marqueId;
    }

    public void setMarqueId(Long marqueId) {
        this.marqueId = marqueId;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Long getIdAnneeSortie() {
        return idAnneeSortie;
    }

    public void setIdAnneeSortie(Long idAnneeSortie) {
        this.idAnneeSortie = idAnneeSortie;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // getters and setters
}