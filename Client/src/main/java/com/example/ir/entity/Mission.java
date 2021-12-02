package com.example.ir.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "mission", indexes = {
        @Index(name = "num_stage", columnList = "num_stage")
})
@Entity
public class Mission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_mission", nullable = false)
    private Integer id;

    @Column(name = "libelle", nullable = false, length = 128)
    private String libelle;

    @ManyToOne(optional = false)
    @JoinColumn(name = "num_stage", nullable = false)
    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
