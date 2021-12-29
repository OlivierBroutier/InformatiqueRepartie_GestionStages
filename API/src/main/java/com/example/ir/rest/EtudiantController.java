package com.example.ir.rest;

import com.example.ir.config.FonctionnelException;
import com.example.ir.dto.EtudiantDTO;
import com.example.ir.service.EtudiantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public ResponseEntity<List<EtudiantDTO>> findAll() {
        return ResponseEntity.ok().body(etudiantService.findAllDTO());
    }

    @GetMapping("{id}")
    public ResponseEntity<EtudiantDTO> findById(@PathVariable(name = "id") Integer id) throws FonctionnelException {
        return ResponseEntity.ok().body(etudiantService.findByIdDTO(id));
    }

    @PostMapping
    public ResponseEntity<EtudiantDTO> create(@RequestBody EtudiantDTO etudiantDTO) {
        return ResponseEntity.ok().body(etudiantService.create(etudiantDTO));
    }

}
