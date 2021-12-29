package com.example.ir.entity;

import java.io.Serializable;
import java.util.Objects;

public class SpecEntrepriseId implements Serializable {

    private Integer entreprise;
    private Integer specialite;

    public Integer getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Integer entreprise) {
        this.entreprise = entreprise;
    }

    public Integer getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Integer specialite) {
        this.specialite = specialite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecEntrepriseId that = (SpecEntrepriseId) o;
        return Objects.equals(getEntreprise(), that.getEntreprise()) && Objects.equals(getSpecialite(), that.getSpecialite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEntreprise(), getSpecialite());
    }
}
