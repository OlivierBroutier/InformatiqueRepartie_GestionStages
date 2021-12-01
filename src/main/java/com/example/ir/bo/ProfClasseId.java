package com.example.ir.bo;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProfClasseId implements Serializable {
    private static final long serialVersionUID = 1320494392832328751L;
    @Column(name = "num_prof", nullable = false)
    private Integer numProf;
    @Column(name = "num_classe", nullable = false)
    private Integer numClasse;

    public Integer getNumClasse() {
        return numClasse;
    }

    public void setNumClasse(Integer numClasse) {
        this.numClasse = numClasse;
    }

    public Integer getNumProf() {
        return numProf;
    }

    public void setNumProf(Integer numProf) {
        this.numProf = numProf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numProf, numClasse);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProfClasseId entity = (ProfClasseId) o;
        return Objects.equals(this.numProf, entity.numProf) &&
                Objects.equals(this.numClasse, entity.numClasse);
    }
}
