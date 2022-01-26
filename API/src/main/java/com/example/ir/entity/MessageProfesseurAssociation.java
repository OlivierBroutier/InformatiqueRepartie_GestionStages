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

@Table(name = "message_professeur")
@Entity
@IdClass(MessageProfesseurAssociationId.class)
public class MessageProfesseurAssociation implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "num_message", updatable = false, referencedColumnName = "num_message")
    private Message message;

    @Id
    @ManyToOne
    @JoinColumn(name = "num_prof", updatable = false, insertable = false, referencedColumnName = "num_prof")
    private Professeur professeur;

    @Column(name = "lu")
    private Boolean lu;

    @Column(name = "supprime")
    private Boolean supprime;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Boolean getLu() {
        return lu;
    }

    public void setLu(Boolean lu) {
        this.lu = lu;
    }

    public Boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(Boolean supprime) {
        this.supprime = supprime;
    }
}
