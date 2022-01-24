package com.example.ir.dto;

import java.io.Serializable;
import java.util.List;

public class MessageDTO implements Serializable {

    private Integer id;
    private MessageUtilisateurDTO expediteur;
    private List<MessageUtilisateurDTO> destinataires;

    public MessageDTO() {
        // no-op
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MessageUtilisateurDTO getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(MessageUtilisateurDTO expediteur) {
        this.expediteur = expediteur;
    }

    public List<MessageUtilisateurDTO> getDestinataires() {
        return destinataires;
    }

    public void setDestinataires(List<MessageUtilisateurDTO> destinataires) {
        this.destinataires = destinataires;
    }
}
