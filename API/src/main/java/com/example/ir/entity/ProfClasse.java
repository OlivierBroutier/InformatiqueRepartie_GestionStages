package com.example.ir.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "prof_classe")
@Entity
@IdClass(ProfClasseId.class)
public class ProfClasse implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "num_prof", referencedColumnName = "num_prof")
    private Professeur professeur;

    @Id
    @ManyToOne
    @JoinColumn(name = "num_classe", referencedColumnName = "num_classe")
    private Classe classe;

    @Column(name = "est_prof_principal", nullable = false)
    private Boolean estProfPrincipal = false;

    public Boolean getEstProfPrincipal() {
        return estProfPrincipal;
    }

    public void setEstProfPrincipal(Boolean estProfPrincipal) {
        this.estProfPrincipal = estProfPrincipal;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
