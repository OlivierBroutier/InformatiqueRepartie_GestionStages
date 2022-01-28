package com.example.ir.service;

import com.example.ir.config.ErrorEnum;
import com.example.ir.config.FonctionnelException;
import com.example.ir.dto.MessageDTO;
import com.example.ir.dto.UtilisateurDTO;
import com.example.ir.entity.Message;
import com.example.ir.entity.MessageEtudiantAssociation;
import com.example.ir.entity.MessageProfesseurAssociation;
import com.example.ir.mapper.MessageMapper;
import com.example.ir.repository.MessageEtudiantRepository;
import com.example.ir.repository.MessageProfesseurRepository;
import com.example.ir.repository.MessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final MessageEtudiantRepository messageEtudiantRepository;
    private final MessageProfesseurRepository messageProfesseurRepository;
    private final EtudiantService etudiantService;
    private final ProfesseurService professeurService;

    public MessageService(
            MessageRepository messageRepository,
            MessageMapper messageMapper,
            MessageEtudiantRepository messageEtudiantRepository,
            MessageProfesseurRepository messageProfesseurRepository,
            EtudiantService etudiantService,
            ProfesseurService professeurService
    ) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
        this.messageEtudiantRepository = messageEtudiantRepository;
        this.messageProfesseurRepository = messageProfesseurRepository;
        this.etudiantService = etudiantService;
        this.professeurService = professeurService;
    }

    public List<MessageDTO> findAll() {
        return messageMapper.toListDTO(messageRepository.findAll());
    }

    public Message findById(Integer id) throws FonctionnelException {
        Optional<Message> oMessage = messageRepository.findById(id);
        if (oMessage.isEmpty()) {
            throw new FonctionnelException(ErrorEnum.MESSAGE_NOT_FOUND);
        }
        return oMessage.get();
    }

    public MessageDTO findByIdDTO(Integer id) throws FonctionnelException {
        return messageMapper.toDTO(findById(id));
    }

    @Transactional(rollbackFor = Exception.class)
    public MessageDTO ajoutMessage(MessageDTO messageDTO) throws FonctionnelException {
        Message message = messageMapper.toBO(messageDTO);
        message.setSupprime(false);

        message = messageRepository.save(message);

        for (MessageEtudiantAssociation messageEtudiantAssociation : message.getDestinatairesEtudiants()) {
            messageEtudiantAssociation.getMessage().setId(message.getId());
            messageEtudiantAssociation.setLu(false);
            messageEtudiantAssociation.setSupprime(false);
        }
        for (MessageProfesseurAssociation messageProfesseurAssociation : message.getDestinatairesProfesseurs()) {
            messageProfesseurAssociation.getMessage().setId(message.getId());
            messageProfesseurAssociation.setLu(false);
            messageProfesseurAssociation.setSupprime(false);
        }

        message.setDestinatairesEtudiants(messageEtudiantRepository.saveAll(message.getDestinatairesEtudiants()));
        message.setDestinatairesProfesseurs(messageProfesseurRepository.saveAll(message.getDestinatairesProfesseurs()));

        if (Objects.nonNull(message.getExpediteurEtudiant())) {
            message.setExpediteurEtudiant(etudiantService.findById(message.getExpediteurEtudiant().getId()));
        } else if (Objects.nonNull(message.getExpediteurProfesseur())) {
            message.setExpediteurProfesseur(professeurService.findById(message.getExpediteurProfesseur().getId()));
        }

        return messageMapper.toDTO(message);
    }

    @Transactional(rollbackFor = Exception.class)
    public MessageDTO markAsLu(Integer messageId, UtilisateurDTO utilisateurDTO) throws FonctionnelException {
        Message message = findById(messageId);

        // Vérif étudiant
        if (Objects.nonNull(utilisateurDTO.getEtudiant())) {
            Optional<MessageEtudiantAssociation> oAssociation = message.getDestinatairesEtudiants().stream().filter(association ->
                            Objects.equals(association.getEtudiant().getId(), utilisateurDTO.getEtudiant().getId()))
                    .findFirst();
            if (oAssociation.isPresent()) {
                MessageEtudiantAssociation association = oAssociation.get();
                association.setLu(true);
                messageEtudiantRepository.save(association);
            } else {
                throw new FonctionnelException(ErrorEnum.ETUDIANT_NOT_FOUND);
            }

        // Vérif professeur
        } else if (Objects.nonNull(utilisateurDTO.getProfesseur())) {
            Optional<MessageProfesseurAssociation> oAssociation = message.getDestinatairesProfesseurs().stream().filter(association ->
                            Objects.equals(association.getProfesseur().getId(), utilisateurDTO.getProfesseur().getId()))
                    .findFirst();
            if (oAssociation.isPresent()) {
                MessageProfesseurAssociation association = oAssociation.get();
                association.setLu(true);
                messageProfesseurRepository.save(association);
            } else {
                throw new FonctionnelException(ErrorEnum.PROFESSEUR_NOT_FOUND);
            }

        // Si aucun des deux présent, erreur
        } else {
            throw new FonctionnelException(ErrorEnum.UTILISATEUR_MISSING);
        }

        return messageMapper.toDTO(findById(messageId));
    }

    @Transactional(rollbackFor = Exception.class)
    public MessageDTO markAsSupprime(Integer messageId, UtilisateurDTO utilisateurDTO) throws FonctionnelException {
        Message message = findById(messageId);

        // Vérif étudiant
        if (Objects.nonNull(utilisateurDTO.getEtudiant())) {
            if (Objects.nonNull(message.getExpediteurEtudiant())) {
                if (Objects.equals(message.getExpediteurEtudiant().getId(), utilisateurDTO.getEtudiant().getId())) {
                    throw new FonctionnelException(ErrorEnum.ETUDIANT_NOT_FOUND);
                } else {
                    message.setSupprime(true);
                    messageRepository.save(message);
                }
            } else {
                Optional<MessageEtudiantAssociation> oAssociation = message.getDestinatairesEtudiants().stream().filter(association ->
                        Objects.equals(association.getEtudiant().getId(), utilisateurDTO.getEtudiant().getId()))
                        .findFirst();
                if (oAssociation.isPresent()) {
                    MessageEtudiantAssociation association = oAssociation.get();
                    association.setSupprime(true);
                    messageEtudiantRepository.save(association);
                } else {
                    throw new FonctionnelException(ErrorEnum.ETUDIANT_NOT_FOUND);
                }
            }

        // Vérif professeur
        } else if (Objects.nonNull(utilisateurDTO.getProfesseur())) {
            if (Objects.nonNull(message.getExpediteurProfesseur())) {
                if (Objects.equals(message.getExpediteurProfesseur().getId(), utilisateurDTO.getProfesseur().getId())) {
                    message.setSupprime(true);
                    messageRepository.save(message);
                } else {
                    throw new FonctionnelException(ErrorEnum.PROFESSEUR_NOT_FOUND);
                }
            } else {
                Optional<MessageProfesseurAssociation> oAssociation = message.getDestinatairesProfesseurs().stream().filter(association ->
                                Objects.equals(association.getProfesseur().getId(), utilisateurDTO.getProfesseur().getId()))
                        .findFirst();
                if (oAssociation.isPresent()) {
                    MessageProfesseurAssociation association = oAssociation.get();
                    association.setSupprime(true);
                    messageProfesseurRepository.save(association);
                } else {
                    throw new FonctionnelException(ErrorEnum.PROFESSEUR_NOT_FOUND);
                }
            }

        // Si aucun des deux présent, erreur
        } else {
            throw new FonctionnelException(ErrorEnum.UTILISATEUR_MISSING);
        }

        return messageMapper.toDTO(findById(messageId));
    }

}
