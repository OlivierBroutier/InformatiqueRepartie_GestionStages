package com.example.ir.rest;

import com.example.ir.config.FonctionnelException;
import com.example.ir.dto.EntrepriseDTO;
import com.example.ir.dto.EtudiantDTO;
import com.example.ir.entity.Etudiant;
import com.example.ir.service.EtudiantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") Integer id) throws FonctionnelException {
        return ResponseEntity.ok().body(etudiantService.delete(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<EtudiantDTO> update(@PathVariable(name = "id") Integer id, @RequestBody EtudiantDTO etudiant) throws FonctionnelException {
        if (!Objects.equals(id, etudiant.getId())) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(etudiantService.update(id, etudiant));
    }


}
