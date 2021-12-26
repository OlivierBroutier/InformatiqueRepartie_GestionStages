package com.example.ir.dto;

import java.io.Serializable;

public class SpecialiteDTO implements Serializable {

    private Integer id;
    private String libelle;

    public SpecialiteDTO() {
        // no-op
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
