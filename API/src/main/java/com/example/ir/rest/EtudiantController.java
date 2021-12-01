package com.example.ir.rest;

import com.example.ir.entity.Etudiant;
import com.example.ir.service.EtudiantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<List<Etudiant>> findAll() {
        return ResponseEntity.ok().body(etudiantService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Etudiant> findById(@PathVariable(name = "id") Integer id) throws Exception {
        return ResponseEntity.ok().body(etudiantService.findById(id));
    }

}
