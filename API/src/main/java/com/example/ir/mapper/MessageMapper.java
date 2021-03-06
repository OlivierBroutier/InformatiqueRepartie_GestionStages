package com.example.ir.mapper;

import com.example.ir.dto.MessageDTO;
import com.example.ir.dto.MessageUtilisateurDTO;
import com.example.ir.dto.MessageUtilisateurType;
import com.example.ir.entity.Etudiant;
import com.example.ir.entity.Message;
import com.example.ir.entity.MessageEtudiantAssociation;
import com.example.ir.entity.MessageProfesseurAssociation;
import com.example.ir.entity.Professeur;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
@Named("Message")
public interface MessageMapper {

    @Named("DTO")
    default MessageDTO toDTO(Message message) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setSujet(message.getSujet());
        messageDTO.setMessage(message.getMessage());

        if (Objects.nonNull(message.getExpediteurEtudiant())) {
            Etudiant etudiant = message.getExpediteurEtudiant();

            MessageUtilisateurDTO expediteur = new MessageUtilisateurDTO();
            expediteur.setMessageUtilisateurType(MessageUtilisateurType.ETUDIANT);
            expediteur.setNom(etudiant.getNomEtudiant());
            expediteur.setPrenom(etudiant.getPrenomEtudiant());
            expediteur.setSupprime(message.getSupprime());

            messageDTO.setExpediteur(expediteur);
        } else if (Objects.nonNull(message.getExpediteurProfesseur())) {
            Professeur professeur = message.getExpediteurProfesseur();

            MessageUtilisateurDTO expediteur = new MessageUtilisateurDTO();
            expediteur.setMessageUtilisateurType(MessageUtilisateurType.PROFESSEUR);
            expediteur.setId(professeur.getId());
            expediteur.setNom(professeur.getNomProf());
            expediteur.setPrenom(professeur.getPrenomProf());
            expediteur.setEmail(professeur.getEmail());
            expediteur.setSupprime(message.getSupprime());

            messageDTO.setExpediteur(expediteur);
        }

        List<MessageUtilisateurDTO> destinataires = new ArrayList<>();
        destinataires.addAll(message.getDestinatairesEtudiants().stream().map(messageEtudiantAssociation -> {
            MessageUtilisateurDTO messageUtilisateurDTO = new MessageUtilisateurDTO();
            messageUtilisateurDTO.setId(messageEtudiantAssociation.getEtudiant().getId());
            messageUtilisateurDTO.setNom(messageEtudiantAssociation.getEtudiant().getNomEtudiant());
            messageUtilisateurDTO.setPrenom(messageEtudiantAssociation.getEtudiant().getPrenomEtudiant());
            messageUtilisateurDTO.setMessageUtilisateurType(MessageUtilisateurType.ETUDIANT);
            messageUtilisateurDTO.setLu(messageEtudiantAssociation.getLu());
            messageUtilisateurDTO.setSupprime(messageEtudiantAssociation.getSupprime());
            return messageUtilisateurDTO;
        }).collect(Collectors.toList()));

        destinataires.addAll(message.getDestinatairesProfesseurs().stream().map(messageProfesseurAssociation -> {
            MessageUtilisateurDTO messageUtilisateurDTO = new MessageUtilisateurDTO();
            messageUtilisateurDTO.setId(messageProfesseurAssociation.getProfesseur().getId());
            messageUtilisateurDTO.setNom(messageProfesseurAssociation.getProfesseur().getNomProf());
            messageUtilisateurDTO.setPrenom(messageProfesseurAssociation.getProfesseur().getPrenomProf());
            messageUtilisateurDTO.setEmail(messageProfesseurAssociation.getProfesseur().getEmail());
            messageUtilisateurDTO.setMessageUtilisateurType(MessageUtilisateurType.PROFESSEUR);
            messageUtilisateurDTO.setLu(messageProfesseurAssociation.getLu());
            messageUtilisateurDTO.setSupprime(messageProfesseurAssociation.getSupprime());
            return messageUtilisateurDTO;
        }).collect(Collectors.toList()));
        messageDTO.setDestinataires(destinataires);

        return messageDTO;
    }

    @Named("ListDTO")
    @IterableMapping(qualifiedByName = "DTO")
    List<MessageDTO> toListDTO(List<Message> messages);

    @Named("EtudiantDTO")
    default MessageDTO toEtudiantDTO(MessageEtudiantAssociation etudiantAssociation) {
        return toDTO(etudiantAssociation.getMessage());
    }

    @Named("ListEtudiantDTO")
    @IterableMapping(qualifiedByName = "EtudiantDTO")
    default List<MessageDTO> toListEtudiantDTO(List<MessageEtudiantAssociation> etudiantAssociations) {
        return etudiantAssociations.stream().map(this::toEtudiantDTO).collect(Collectors.toList());
    }

    @Named("ProfesseurDTO")
    default MessageDTO toProfesseurDTO(MessageProfesseurAssociation professeurAssociation) {
        return toDTO(professeurAssociation.getMessage());
    }

    @Named("ListProfesseurDTO")
    default List<MessageDTO> toListProfesseurDTO(List<MessageProfesseurAssociation> professeurAssociations) {
        return professeurAssociations.stream().map(this::toProfesseurDTO).collect(Collectors.toList());
    }



    @Named("BO")
    default Message toBO(MessageDTO messageDTO) {
        Message message = new Message();
        message.setId(messageDTO.getId());
        message.setSujet(messageDTO.getSujet());
        message.setMessage(messageDTO.getMessage());
        message.setSupprime(messageDTO.getExpediteur().getSupprime());

        if (Objects.nonNull(messageDTO.getExpediteur())) {
            switch (messageDTO.getExpediteur().getMessageUtilisateurType()) {
                case ETUDIANT:
                    Etudiant etudiant = new Etudiant();
                    etudiant.setId(messageDTO.getExpediteur().getId());
                    message.setExpediteurEtudiant(etudiant);
                    break;
                case PROFESSEUR:
                    Professeur professeur = new Professeur();
                    professeur.setId(messageDTO.getExpediteur().getId());
                    message.setExpediteurProfesseur(professeur);
                    break;
            }
        }

        if (Objects.nonNull(messageDTO.getDestinataires())) {
            messageDTO.getDestinataires().forEach(messageUtilisateurDTO -> {
                switch (messageUtilisateurDTO.getMessageUtilisateurType()) {
                    case ETUDIANT:
                        Etudiant etudiant = new Etudiant();
                        etudiant.setId(messageUtilisateurDTO.getId());

                        MessageEtudiantAssociation messageEtudiantAssociation = new MessageEtudiantAssociation();
                        messageEtudiantAssociation.setMessage(message);
                        messageEtudiantAssociation.setEtudiant(etudiant);
                        messageEtudiantAssociation.setLu(messageUtilisateurDTO.getLu());
                        messageEtudiantAssociation.setSupprime(messageUtilisateurDTO.getSupprime());

                        message.getDestinatairesEtudiants().add(messageEtudiantAssociation);
                        break;
                    case PROFESSEUR:
                        Professeur professeur = new Professeur();
                        professeur.setId(messageUtilisateurDTO.getId());

                        MessageProfesseurAssociation messageProfesseurAssociation = new MessageProfesseurAssociation();
                        messageProfesseurAssociation.setMessage(message);
                        messageProfesseurAssociation.setProfesseur(professeur);
                        messageProfesseurAssociation.setLu(messageUtilisateurDTO.getLu());
                        messageProfesseurAssociation.setSupprime(messageUtilisateurDTO.getSupprime());

                        message.getDestinatairesProfesseurs().add(messageProfesseurAssociation);
                        break;
                }
            });
        }

        return message;
    }

}
