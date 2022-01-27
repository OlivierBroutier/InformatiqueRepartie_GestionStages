package com.example.ir.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDTO implements Serializable {

    private Integer id;
    private String nomEtudiant;
    private String prenomEtudiant;
    private LocalDate anneeObtention;
    private String login;
    private String mdp;
    private ClasseDTO classe;
    private Boolean enActivite;
    private List<StageDTO> stages = new ArrayList<>();
    private List<MessageDTO> messagesEnvoyes = new ArrayList<>();
    private List<MessageDTO> messagesRecus = new ArrayList<>();

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

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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

    public List<StageDTO> getStages() {
        return stages;
    }

    public void setStages(List<StageDTO> stages) {
        this.stages = stages;
    }

    public List<MessageDTO> getMessagesEnvoyes() {
        return messagesEnvoyes;
    }

    public void setMessagesEnvoyes(List<MessageDTO> messagesEnvoyes) {
        this.messagesEnvoyes = messagesEnvoyes;
    }

    public List<MessageDTO> getMessagesRecus() {
        return messagesRecus;
    }

    public void setMessagesRecus(List<MessageDTO> messagesRecus) {
        this.messagesRecus = messagesRecus;
    }
}
