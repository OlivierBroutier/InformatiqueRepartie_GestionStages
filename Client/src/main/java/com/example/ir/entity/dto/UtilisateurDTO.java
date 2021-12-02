package com.example.ir.entity.dto;

import com.example.ir.entity.Etudiant;
import com.example.ir.entity.Professeur;

import java.io.Serializable;

public class UtilisateurDTO implements Serializable {

    private Etudiant etudiant;
    private Professeur professeur;

    public UtilisateurDTO() { }

    public UtilisateurDTO(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public UtilisateurDTO(Professeur professeur) {
        this.professeur = professeur;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
}
