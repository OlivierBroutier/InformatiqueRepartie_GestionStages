package com.example.ir.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "etudiant", indexes = {
        @Index(name = "num_classe", columnList = "num_classe")
})
@Entity
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_etudiant", nullable = false)
    private Integer id;

    @Column(name = "nom_etudiant", nullable = false, length = 64)
    private String nomEtudiant;

    @Column(name = "prenom_etudiant", nullable = false, length = 64)
    private String prenomEtudiant;

    @Column(name = "annee_obtention")
    private LocalDate anneeObtention;

    @Column(name = "login", nullable = false, length = 8)
    private String login;

    @Column(name = "mdp", nullable = false, length = 30)
    private String mdp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "num_classe", nullable = false)
    private Classe classe;

    @Column(name = "en_activite", nullable = false)
    private Boolean enActivite = false;

    public Boolean getEnActivite() {
        return enActivite;
    }

    public void setEnActivite(Boolean enActivite) {
        this.enActivite = enActivite;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDate getAnneeObtention() {
        return anneeObtention;
    }

    public void setAnneeObtention(LocalDate anneeObtention) {
        this.anneeObtention = anneeObtention;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
