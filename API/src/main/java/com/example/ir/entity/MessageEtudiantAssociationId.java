package com.example.ir.entity;

import java.io.Serializable;
import java.util.Objects;

public class MessageEtudiantAssociationId implements Serializable {

    private Integer message;
    private Integer etudiant;

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Integer etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEtudiantAssociationId that = (MessageEtudiantAssociationId) o;
        return Objects.equals(getMessage(), that.getMessage()) && Objects.equals(getEtudiant(), that.getEtudiant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessage(), getEtudiant());
    }
}
