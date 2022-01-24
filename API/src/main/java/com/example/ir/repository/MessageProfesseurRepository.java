package com.example.ir.repository;

import com.example.ir.entity.MessageProfesseurAssociation;
import com.example.ir.entity.MessageProfesseurAssociationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageProfesseurRepository extends JpaRepository<MessageProfesseurAssociation, MessageProfesseurAssociationId> {
}
