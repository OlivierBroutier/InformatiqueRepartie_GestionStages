package com.example.ir.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "classe")
@Entity
public class Classe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_classe", nullable = false)
    private Integer id;

    @Column(name = "nom_classe", nullable = false, length = 128)
    private String nomClasse;

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
