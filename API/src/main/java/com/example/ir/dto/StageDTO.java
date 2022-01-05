package com.example.ir.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StageDTO implements Serializable {

    private Integer id;
    private LocalDate debutStage;
    private LocalDate finStage;
    private String typeStage;
    private String descProjet;
    private String observationStage;
    private EtudiantDTO etudiant;
    private ProfesseurDTO professeur;
    private EntrepriseDTO entreprise;
    private List<MissionDTO> missions = new ArrayList<>();

    public StageDTO() {
        // no-op
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDebutStage() {
        return debutStage;
    }

    public void setDebutStage(LocalDate debutStage) {
        this.debutStage = debutStage;
    }

    public LocalDate getFinStage() {
        return finStage;
    }

    public void setFinStage(LocalDate finStage) {
        this.finStage = finStage;
    }

    public String getTypeStage() {
        return typeStage;
    }

    public void setTypeStage(String typeStage) {
        this.typeStage = typeStage;
    }

    public String getDescProjet() {
        return descProjet;
    }

    public void setDescProjet(String descProjet) {
        this.descProjet = descProjet;
    }

    public String getObservationStage() {
        return observationStage;
    }

    public void setObservationStage(String observationStage) {
        this.observationStage = observationStage;
    }

    public EtudiantDTO getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(EtudiantDTO etudiant) {
        this.etudiant = etudiant;
    }

    public ProfesseurDTO getProfesseur() {
        return professeur;
    }

    public void setProfesseur(ProfesseurDTO professeur) {
        this.professeur = professeur;
    }

    public EntrepriseDTO getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(EntrepriseDTO entreprise) {
        this.entreprise = entreprise;
    }

    public List<MissionDTO> getMissions() {
        return missions;
    }

    public void setMissions(List<MissionDTO> missions) {
        this.missions = missions;
    }
}
