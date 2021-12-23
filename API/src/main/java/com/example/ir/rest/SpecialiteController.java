package com.example.ir.rest;

import com.example.ir.entity.Specialite;
import com.example.ir.service.SpecialiteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/specialite")
public class SpecialiteController {

    private final SpecialiteService specialiteService;

    public SpecialiteController(SpecialiteService specialiteService) {
        this.specialiteService = specialiteService;
    }

    @GetMapping
    public ResponseEntity<List<Specialite>> findAll() {
        return ResponseEntity.ok().body(specialiteService.findAll());
    }

}
