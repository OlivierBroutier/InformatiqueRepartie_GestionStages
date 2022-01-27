package com.example.ir.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProfesseurDTO implements Serializable {

    private Integer id;
    private String nomProf;
    private String prenomProf;
    private String login;
    private String mdp;
    private String email;
    private List<StageDTO> stages = new ArrayList<>();
    private List<MessageDTO> messagesEnvoyes = new ArrayList<>();
    private List<MessageDTO> messagesRecus = new ArrayList<>();

    public ProfesseurDTO() {
        // no-op
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }

    public String getPrenomProf() {
        return prenomProf;
    }

    public void setPrenomProf(String prenomProf) {
        this.prenomProf = prenomProf;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
