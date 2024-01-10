package com.spring.models.view;

import com.spring.dao.annotation.Column;
import com.spring.dao.annotation.Table;
import com.spring.dao.dao.Generic2;

@Table(libelle = "v_model_details")
public class ModelDetailView extends Generic2 {
    @Column(libelle = "id_model")
    private Integer idModel;
    @Column(libelle = "model")
    private String model;
    @Column(libelle = "id_marque")
    private Integer idMarque;
    @Column(libelle = "marque")
    private String marque;
    @Column(libelle = "id_categorie")
    private Integer idCategorie;
    @Column(libelle = "categorie")
    private String categorie;

    public Integer getIdModel() {
        return idModel;
    }

    public void setIdModel(Integer idModel) {
        this.idModel = idModel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

}
