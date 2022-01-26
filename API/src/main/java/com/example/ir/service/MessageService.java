package com.example.ir.service;

import com.example.ir.dto.MessageDTO;
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

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final MessageEtudiantRepository messageEtudiantRepository;
    private final MessageProfesseurRepository messageProfesseurRepository;

    public MessageService(
            MessageRepository messageRepository,
            MessageMapper messageMapper,
            MessageEtudiantRepository messageEtudiantRepository,
            MessageProfesseurRepository messageProfesseurRepository
    ) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
        this.messageEtudiantRepository = messageEtudiantRepository;
        this.messageProfesseurRepository = messageProfesseurRepository;
    }

    public List<MessageDTO> findAll() {
        return messageMapper.toListDTO(messageRepository.findAll());
    }

    @Transactional(rollbackFor = Exception.class)
    public MessageDTO ajoutMessage(MessageDTO messageDTO) {
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

        messageEtudiantRepository.saveAll(message.getDestinatairesEtudiants());
        messageProfesseurRepository.saveAll(message.getDestinatairesProfesseurs());

        return messageMapper.toDTO(message);
    }

}
