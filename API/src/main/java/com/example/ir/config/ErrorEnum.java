package com.example.ir.config;

import org.springframework.http.HttpStatus;

public enum ErrorEnum {

    STAGE_NOT_FOUND("Le stage n'a pas été trouvé"),
    ETUDIANT_NOT_FOUND("L'étudiant n'a pas été trouvé"),
    ETUDIANT_WITH_LOGIN_NOT_FOUND("Aucun étudiant trouvé avec ces identifiants"),
    PROFESSEUR_WITH_LOGIN_NOT_FOUND("Aucun professeur trouvé avec ces identifiants"),
    PROFESSEUR_NOT_FOUND("Le professeur n'a pas été trouvé"),
    USER_WITH_LOGIN_NOT_FOUND("Aucun utilisateur trouvé avec ces identifiants"),
    MESSAGE_NOT_FOUND("Le message n'a pas été trouvé"),
    UTILISATEUR_MISSING("L'utilisateur n'a pas été renseigné"),
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
