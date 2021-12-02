package com.example.ir.rest;

import com.example.ir.entity.dto.LoginDTO;
import com.example.ir.entity.dto.UtilisateurDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class LoginRest {

    private final String BASE_URL = "http://localhost:8081/api/login/";

    private final WebTarget webTarget;
    private final Client client;

    public LoginRest() {
        this.client = ClientBuilder.newClient();
        this.webTarget = this.client.target(BASE_URL);
    }

    public UtilisateurDTO login(LoginDTO loginDTO) throws Exception {
        Response response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(loginDTO, MediaType.APPLICATION_JSON));
        if (response.getStatusInfo().toEnum() == Response.Status.INTERNAL_SERVER_ERROR) {
            throw new Exception(response.readEntity(String.class));
        }

        return response.readEntity(UtilisateurDTO.class);
    }

}
