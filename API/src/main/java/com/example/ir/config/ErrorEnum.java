package com.example.ir.config;

public enum ErrorEnum {

    STAGE_NOT_FOUND("Le stage n'a pas été trouvé"),
    ETUDIANT_NOT_FOUND("L'étudiant n'a pas été trouvé"),
    ENTREPRISE_NOT_FOUND("L'entreprise n'a pas été trouvée");

    private final String message;

    ErrorEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
