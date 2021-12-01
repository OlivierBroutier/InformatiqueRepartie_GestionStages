package com.example.ir.bo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "prof_classe", indexes = {
        @Index(name = "num_classe", columnList = "num_classe")
})
@Entity
public class ProfClasse implements Serializable {

    @EmbeddedId
    private ProfClasseId id;

    @Column(name = "est_prof_principal", nullable = false)
    private Boolean estProfPrincipal = false;

    public Boolean getEstProfPrincipal() {
        return estProfPrincipal;
    }

    public void setEstProfPrincipal(Boolean estProfPrincipal) {
        this.estProfPrincipal = estProfPrincipal;
    }

    public ProfClasseId getId() {
        return id;
    }

    public void setId(ProfClasseId id) {
        this.id = id;
    }

}
