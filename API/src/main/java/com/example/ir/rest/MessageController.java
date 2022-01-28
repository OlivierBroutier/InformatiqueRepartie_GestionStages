package com.example.ir.rest;

import com.example.ir.config.FonctionnelException;
import com.example.ir.dto.MessageDTO;
import com.example.ir.dto.UtilisateurDTO;
import com.example.ir.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<List<MessageDTO>> findAll() {
        return ResponseEntity.ok().body(messageService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<MessageDTO> findById(@PathVariable("id") Integer id) throws FonctionnelException {
        return ResponseEntity.ok().body(messageService.findByIdDTO(id));
    }

    @PostMapping
    public ResponseEntity<MessageDTO> ajoutMessage(@RequestBody MessageDTO messageDTO) throws FonctionnelException {
        return ResponseEntity.ok().body(messageService.ajoutMessage(messageDTO));
    }

    @PutMapping("{id}/lu")
    public ResponseEntity<MessageDTO> markAsLu(
            @PathVariable("id") Integer messageId,
            @RequestBody UtilisateurDTO utilisateurDTO
    ) throws FonctionnelException {
        return ResponseEntity.ok().body(messageService.markAsLu(messageId, utilisateurDTO));
    }

    @PutMapping("{id}/supprime")
    public ResponseEntity<MessageDTO> markAsSupprime(
            @PathVariable("id") Integer messageId,
            @RequestBody UtilisateurDTO utilisateurDTO
    ) throws FonctionnelException {
        return ResponseEntity.ok().body(messageService.markAsSupprime(messageId, utilisateurDTO));
    }

}
