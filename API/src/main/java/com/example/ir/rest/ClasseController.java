package com.example.ir.rest;

import com.example.ir.dto.ClasseDTO;
import com.example.ir.entity.Classe;
import com.example.ir.service.ClasseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/classe")
public class ClasseController {

    private final ClasseService classeService;

    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }

    @GetMapping
    public ResponseEntity<List<ClasseDTO>> findAll() {
        return ResponseEntity.ok().body(classeService.findAllDTO());
    }

}
