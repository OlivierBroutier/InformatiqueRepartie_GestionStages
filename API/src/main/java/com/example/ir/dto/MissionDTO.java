package com.example.ir.dto;

import java.io.Serializable;

public class MissionDTO implements Serializable {

    private Integer id;
    private String libelle;
    private StageDTO stage;

    public MissionDTO() {
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

    public StageDTO getStage() {
        return stage;
    }

    public void setStage(StageDTO stage) {
        this.stage = stage;
    }
}
