package com.example.ir.config;

import org.springframework.http.HttpStatus;

public enum ErrorEnum {

    STAGE_NOT_FOUND("Le stage n'a pas été trouvé"),
    ETUDIANT_NOT_FOUND("L'étudiant n'a pas été trouvé"),
    ETUDIANT_WITH_LOGIN_NOT_FOUND("Aucun étudiant trouvé avec ces identifiants"),
    PROFESSEUR_WITH_LOGIN_NOT_FOUND("Aucun professeur trouvé avec ces identifiants"),
    USER_WITH_LOGIN_NOT_FOUND("Aucun utilisateur trouvé avec ces identifiants"),
    ENTREPRISE_NOT_FOUND("L'entreprise n'a pas été trouvée");

    private final String description;
    private final HttpStatus status;

    ErrorEnum(String message) {
        this.description = message;
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public String getDescription() {
        return description;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
