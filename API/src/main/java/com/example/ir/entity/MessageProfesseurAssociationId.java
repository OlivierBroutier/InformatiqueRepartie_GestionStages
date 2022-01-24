package com.example.ir.entity;

import java.io.Serializable;
import java.util.Objects;

public class MessageProfesseurAssociationId implements Serializable {

    private Integer message;
    private Integer professeur;

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Integer professeur) {
        this.professeur = professeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageProfesseurAssociationId that = (MessageProfesseurAssociationId) o;
        return getProfesseur() == that.getProfesseur() && Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessage(), getProfesseur());
    }
}
