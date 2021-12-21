package com.example.ir.rest;

import com.example.ir.config.FonctionnelException;
import com.example.ir.entity.Stage;
import com.example.ir.service.StageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/stage")
public class StageController {

    private StageService stage_service;

    public StageController(StageService stage_service) {
        this.stage_service = stage_service;
    }

    @GetMapping
    public List<Stage> findAll() {
        return stage_service.findAll();
    }

    @GetMapping(value= "/{id}")
    public Stage findStageById(@PathVariable(name = "id") int id) throws FonctionnelException {
        return stage_service.findAllById(id);
    }

    @GetMapping(value="entreprise/{id_entreprise}")
    public List<Stage> findStageByEntrepriseId(@PathVariable(name="id_entreprise") int id) throws FonctionnelException {
        return stage_service.findStagesByEntrepriseId(id);
    }

}
