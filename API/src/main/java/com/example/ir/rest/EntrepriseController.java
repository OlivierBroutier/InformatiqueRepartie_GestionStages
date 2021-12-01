package com.example.ir.rest;

import com.example.ir.entity.Entreprise;
import com.example.ir.service.EntrepriseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Entreprise>> findAll() {
        return ResponseEntity.ok().body(entrepriseService.findAll());
    }

    @GetMapping(value="{id}")
    public ResponseEntity<Entreprise> findById(@PathVariable(name="id") Integer id) throws Exception {
        return ResponseEntity.ok().body(entrepriseService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Entreprise> create(@RequestBody Entreprise entreprise) {
        return ResponseEntity.ok().body(entrepriseService.create(entreprise));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Entreprise> update(@PathVariable(name = "id") Integer id, @RequestBody Entreprise entreprise) throws Exception {
        if (!Objects.equals(id, entreprise.getId())) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(entrepriseService.update(id, entreprise));
    }

}
