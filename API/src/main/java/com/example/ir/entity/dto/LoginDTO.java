package com.example.ir.entity.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable {

    private String login;
    private String mdp;
    private String statut;

    public LoginDTO() { }

    public LoginDTO(String login, String mdp, String statut) {
        this.login = login;
        this.mdp = mdp;
        this.statut= statut;
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
