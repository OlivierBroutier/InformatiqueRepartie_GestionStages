package com.example.ir.rest;

import com.example.ir.dto.ProfesseurDTO;
import com.example.ir.entity.Professeur;
import com.example.ir.service.ProfesseurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/professeur")
public class ProfesseurController {

    private final ProfesseurService professeurService;

    public ProfesseurController(ProfesseurService professeurService) {
        this.professeurService = professeurService;
    }

    @GetMapping
    public ResponseEntity<List<ProfesseurDTO>> findAll() {
        return ResponseEntity.ok().body(professeurService.findAllDTO());
    }

}
