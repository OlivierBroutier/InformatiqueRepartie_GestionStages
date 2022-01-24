package com.example.ir.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "message_etudiant")
@Entity
@IdClass(MessageEtudiantAssociationId.class)
public class MessageEtudiantAssociation implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "num_message", updatable = false, referencedColumnName = "num_message")
    private Message message;

    @Id
    @ManyToOne
    @JoinColumn(name = "num_etudiant", updatable = false, insertable = false, referencedColumnName = "num_etudiant")
    private Etudiant etudiant;

    @Column(name = "lu")
    private Boolean lu;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Boolean getLu() {
        return lu;
    }

    public void setLu(Boolean lu) {
        this.lu = lu;
    }
}
