package com.example.ir.repository;

import com.example.ir.entity.MessageEtudiantAssociation;
import com.example.ir.entity.MessageEtudiantAssociationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageEtudiantRepository extends JpaRepository<MessageEtudiantAssociation, MessageEtudiantAssociationId> {
}
