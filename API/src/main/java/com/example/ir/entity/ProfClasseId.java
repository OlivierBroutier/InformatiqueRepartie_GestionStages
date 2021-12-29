package com.example.ir.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProfClasseId implements Serializable {

    private Integer professeur;
    private Integer classe;

    public Integer getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Integer professeur) {
        this.professeur = professeur;
    }

    public Integer getClasse() {
        return classe;
    }

    public void setClasse(Integer classe) {
        this.classe = classe;
    }
}
