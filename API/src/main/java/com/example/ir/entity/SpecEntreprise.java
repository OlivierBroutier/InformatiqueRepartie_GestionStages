package com.example.ir.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "spec_entreprise", indexes = {
        @Index(name = "num_spec", columnList = "num_spec")
})
@Entity
public class SpecEntreprise implements Serializable {

    @EmbeddedId
    private SpecEntrepriseId id;

    public SpecEntrepriseId getId() {
        return id;
    }

    public void setId(SpecEntrepriseId id) {
        this.id = id;
    }

}
