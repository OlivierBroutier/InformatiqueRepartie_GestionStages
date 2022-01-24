package com.example.ir.dto;

import java.io.Serializable;

public class MessageUtilisateurDTO implements Serializable {

    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private MessageUtilisateurType messageUtilisateurType;
    private Boolean lu;

    public MessageUtilisateurDTO() {
        // no-op
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MessageUtilisateurType getMessageUtilisateurType() {
        return messageUtilisateurType;
    }

    public void setMessageUtilisateurType(MessageUtilisateurType messageUtilisateurType) {
        this.messageUtilisateurType = messageUtilisateurType;
    }

    public Boolean getLu() {
        return lu;
    }

    public void setLu(Boolean lu) {
        this.lu = lu;
    }
}
