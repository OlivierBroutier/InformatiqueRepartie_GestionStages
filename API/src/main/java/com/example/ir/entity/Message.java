package com.example.ir.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "message", indexes = {
        @Index(name = "num_message", columnList = "num_message")
})
@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_message", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "num_expediteur_etudiant")
    private Etudiant expediteurEtudiant;

    @ManyToOne
    @JoinColumn(name = "num_expediteur_prof")
    private Professeur expediteurProfesseur;

    @OneToMany(mappedBy = "message")
    private List<MessageEtudiantAssociation> destinatairesEtudiants = new ArrayList<>();

    @OneToMany(mappedBy = "message")
    private List<MessageProfesseurAssociation> destinatairesProfesseurs = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Etudiant getExpediteurEtudiant() {
        return expediteurEtudiant;
    }

    public void setExpediteurEtudiant(Etudiant expediteurEtudiant) {
        this.expediteurEtudiant = expediteurEtudiant;
    }

    public Professeur getExpediteurProfesseur() {
        return expediteurProfesseur;
    }

    public void setExpediteurProfesseur(Professeur expediteurProfesseur) {
        this.expediteurProfesseur = expediteurProfesseur;
    }

    public List<MessageEtudiantAssociation> getDestinatairesEtudiants() {
        return destinatairesEtudiants;
    }

    public void setDestinatairesEtudiants(List<MessageEtudiantAssociation> destinatairesEtudiants) {
        this.destinatairesEtudiants = destinatairesEtudiants;
    }

    public List<MessageProfesseurAssociation> getDestinatairesProfesseurs() {
        return destinatairesProfesseurs;
    }

    public void setDestinatairesProfesseurs(List<MessageProfesseurAssociation> destinatairesProfesseurs) {
        this.destinatairesProfesseurs = destinatairesProfesseurs;
    }
}
