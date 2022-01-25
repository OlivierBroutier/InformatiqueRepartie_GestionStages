package com.example.ir.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "login", nullable = false, updatable = false, length = 8)
    private String login;

    @Column(name = "mdp", nullable = false, updatable = false, length = 30)
    private String mdp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "num_classe", nullable = false)
    private Classe classe;

    @Column(name = "en_activite", nullable = false)
    private Boolean enActivite = false;

    @OneToMany(mappedBy = "etudiant", fetch = FetchType.LAZY)
    private List<Stage> stages = new ArrayList<>();

    @OneToMany(mappedBy = "expediteurEtudiant")
    private List<Message> messagesEnvoyes = new ArrayList<>();

    @OneToMany(mappedBy = "etudiant")
    private List<MessageEtudiantAssociation> destinatairesEtudiants = new ArrayList<>();

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

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    public List<Message> getMessagesEnvoyes() {
        return messagesEnvoyes;
    }

    public void setMessagesEnvoyes(List<Message> messagesEnvoyes) {
        this.messagesEnvoyes = messagesEnvoyes;
    }

    public List<MessageEtudiantAssociation> getDestinatairesEtudiants() {
        return destinatairesEtudiants;
    }

    public void setDestinatairesEtudiants(List<MessageEtudiantAssociation> destinatairesEtudiants) {
        this.destinatairesEtudiants = destinatairesEtudiants;
    }
}
