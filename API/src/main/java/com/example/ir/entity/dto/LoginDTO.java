package com.example.ir.entity.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable {

    private String login;
    private String mdp;

    public LoginDTO() { }

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
}
