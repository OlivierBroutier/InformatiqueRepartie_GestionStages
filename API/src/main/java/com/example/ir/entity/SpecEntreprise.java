package com.example.ir.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "spec_entreprise")
@Entity
@IdClass(SpecEntrepriseId.class)
public class SpecEntreprise implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "num_entreprise", referencedColumnName = "num_entreprise")
    private Entreprise entreprise;

    @Id
    @ManyToOne
    @JoinColumn(name = "num_spec", referencedColumnName = "num_spec")
    private Specialite specialite;

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }
}
