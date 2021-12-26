package com.example.ir.entity.dto;

import com.example.ir.dto.EtudiantDTO;
import com.example.ir.dto.ProfesseurDTO;

import java.io.Serializable;

public class UtilisateurDTO implements Serializable {

    private EtudiantDTO etudiant;
    private ProfesseurDTO professeur;

    public UtilisateurDTO() { }

    public UtilisateurDTO(EtudiantDTO etudiant) {
        this.etudiant = etudiant;
    }

    public UtilisateurDTO(ProfesseurDTO professeur) {
        this.professeur = professeur;
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
}
