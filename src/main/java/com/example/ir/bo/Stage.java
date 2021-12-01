package com.example.ir.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;

@Table(name = "stage", indexes = {
        @Index(name = "num_prof", columnList = "num_prof"),
        @Index(name = "num_entreprise", columnList = "num_entreprise"),
        @Index(name = "num_etudiant", columnList = "num_etudiant")
})
@Entity
public class Stage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_stage", nullable = false)
    private Integer id;

    @Column(name = "debut_stage", nullable = false)
    private Instant debutStage;

    @Column(name = "fin_stage", nullable = false)
    private Instant finStage;

    @Column(name = "type_stage", length = 128)
    private String typeStage;

    @Lob
    @Column(name = "desc_projet")
    private String descProjet;

    @Lob
    @Column(name = "observation_stage")
    private String observationStage;

    @ManyToOne(optional = false)
    @JoinColumn(name = "num_etudiant", nullable = false)
    private Etudiant etudiant;

    @ManyToOne(optional = false)
    @JoinColumn(name = "num_prof", nullable = false)
    private Professeur professeur;

    @ManyToOne(optional = false)
    @JoinColumn(name = "num_entreprise", nullable = false)
    private Entreprise entreprise;

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public String getObservationStage() {
        return observationStage;
    }

    public void setObservationStage(String observationStage) {
        this.observationStage = observationStage;
    }

    public String getDescProjet() {
        return descProjet;
    }

    public void setDescProjet(String descProjet) {
        this.descProjet = descProjet;
    }

    public String getTypeStage() {
        return typeStage;
    }

    public void setTypeStage(String typeStage) {
        this.typeStage = typeStage;
    }

    public Instant getFinStage() {
        return finStage;
    }

    public void setFinStage(Instant finStage) {
        this.finStage = finStage;
    }

    public Instant getDebutStage() {
        return debutStage;
    }

    public void setDebutStage(Instant debutStage) {
        this.debutStage = debutStage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
