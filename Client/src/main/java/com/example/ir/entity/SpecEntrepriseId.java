package com.example.ir.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SpecEntrepriseId implements Serializable {
    private static final long serialVersionUID = -6117744997646784729L;
    @Column(name = "num_entreprise", nullable = false)
    private Integer numEntreprise;
    @Column(name = "num_spec", nullable = false)
    private Integer numSpec;

    public Integer getNumSpec() {
        return numSpec;
    }

    public void setNumSpec(Integer numSpec) {
        this.numSpec = numSpec;
    }

    public Integer getNumEntreprise() {
        return numEntreprise;
    }

    public void setNumEntreprise(Integer numEntreprise) {
        this.numEntreprise = numEntreprise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecEntrepriseId that = (SpecEntrepriseId) o;
        return Objects.equals(numEntreprise, that.numEntreprise) && Objects.equals(numSpec, that.numSpec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numEntreprise, numSpec);
    }
}
