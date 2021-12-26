package com.example.ir.rest;

import com.example.ir.config.FonctionnelException;
import com.example.ir.dto.EntrepriseDTO;
import com.example.ir.entity.Entreprise;
import com.example.ir.service.EntrepriseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/entreprise")
public class EntrepriseController {

    private final EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @GetMapping
    public ResponseEntity<List<EntrepriseDTO>> findAll() {
        return ResponseEntity.ok().body(entrepriseService.findAll());
    }

    @GetMapping(value="{id}")
    public ResponseEntity<EntrepriseDTO> findById(@PathVariable(name="id") Integer id) throws FonctionnelException {
        return ResponseEntity.ok().body(entrepriseService.findByIdDTO(id));
    }

    @PostMapping
    public ResponseEntity<EntrepriseDTO> create(@RequestBody EntrepriseDTO entreprise) {
        return ResponseEntity.ok().body(entrepriseService.create(entreprise));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<EntrepriseDTO> update(@PathVariable(name = "id") Integer id, @RequestBody EntrepriseDTO entreprise) throws FonctionnelException {
        if (!Objects.equals(id, entreprise.getId())) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(entrepriseService.update(id, entreprise));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(entrepriseService.delete(id));
    }

}
