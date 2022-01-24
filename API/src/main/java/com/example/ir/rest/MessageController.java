package com.example.ir.rest;

import com.example.ir.dto.MessageDTO;
import com.example.ir.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public ResponseEntity<MessageDTO> ajoutMessage(@RequestBody MessageDTO messageDTO) {
        return ResponseEntity.ok().body(messageService.ajoutMessage(messageDTO));
    }

}
