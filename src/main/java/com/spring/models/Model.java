package com.spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_model;
    private Long marque_id;
    private Long categorie_id;
    private String model;

    public Long getMarque_id() {
        return marque_id;
    }

    public void setMarque_id(Long marque_id) {
        this.marque_id = marque_id;
    }

    public Long getId_model() {
        return id_model;
    }

    public void setId_model(Long id_model) {
        this.id_model = id_model;
    }

    public Long getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(Long categorie_id) {
        this.categorie_id = categorie_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
