package com.example.ir.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class EtudiantDTO implements Serializable {

    private Integer id;
    private String nomEtudiant;
    private String prenomEtudiant;
    private LocalDate anneeObtention;
    private String login;
    private ClasseDTO classe;
    private Boolean enActivite;

    public EtudiantDTO() {
        // no-op
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public LocalDate getAnneeObtention() {
        return anneeObtention;
    }

    public void setAnneeObtention(LocalDate anneeObtention) {
        this.anneeObtention = anneeObtention;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public ClasseDTO getClasse() {
        return classe;
    }

    public void setClasse(ClasseDTO classe) {
        this.classe = classe;
    }

    public Boolean getEnActivite() {
        return enActivite;
    }

    public void setEnActivite(Boolean enActivite) {
        this.enActivite = enActivite;
    }
}
