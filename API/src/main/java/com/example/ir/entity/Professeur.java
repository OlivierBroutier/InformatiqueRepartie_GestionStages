package com.example.ir.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "professeur")
@Entity
public class Professeur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_prof", nullable = false)
    private Integer id;

    @Column(name = "nom_prof", nullable = false, length = 64)
    private String nomProf;

    @Column(name = "prenom_prof", nullable = false, length = 64)
    private String prenomProf;

    @Column(name = "login", nullable = false, length = 8)
    private String login;

    @Column(name = "mdp", nullable = false, length = 8)
    private String mdp;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "professeur", fetch = FetchType.LAZY)
    private List<Stage> stages = new ArrayList<>();

    @OneToMany(mappedBy = "professeur", cascade = CascadeType.ALL)
    private List<ProfClasse> profClasseAssoc = new ArrayList<>();

    @OneToMany(mappedBy = "expediteurProfesseur")
    private List<Message> messagesEnvoyes = new ArrayList<>();

    @OneToMany(mappedBy = "professeur")
    private List<MessageProfesseurAssociation> destinatairesProfesseurs = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPrenomProf() {
        return prenomProf;
    }

    public void setPrenomProf(String prenomProf) {
        this.prenomProf = prenomProf;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
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

    public List<ProfClasse> getProfClasseAssoc() {
        return profClasseAssoc;
    }

    public void setProfClasseAssoc(List<ProfClasse> profClasseAssoc) {
        this.profClasseAssoc = profClasseAssoc;
    }

    public List<Message> getMessagesEnvoyes() {
        return messagesEnvoyes;
    }

    public void setMessagesEnvoyes(List<Message> messagesEnvoyes) {
        this.messagesEnvoyes = messagesEnvoyes;
    }

    public List<MessageProfesseurAssociation> getDestinatairesProfesseurs() {
        return destinatairesProfesseurs;
    }

    public void setDestinatairesProfesseurs(List<MessageProfesseurAssociation> destinatairesProfesseurs) {
        this.destinatairesProfesseurs = destinatairesProfesseurs;
    }
}
