package com.example.ir.rest;

import com.example.ir.config.FonctionnelException;
import com.example.ir.dto.StageDTO;
import com.example.ir.entity.Stage;
import com.example.ir.service.StageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/stage")
public class StageController {

    private final StageService stageService;

    public StageController(StageService stage_service) {
        this.stageService = stage_service;
    }

    @GetMapping
    public List<StageDTO> findAll() {
        return stageService.findAllDTO();
    }

    @GetMapping(value= "/{id}")
    public StageDTO findStageById(@PathVariable(name = "id") int id) throws FonctionnelException {
        return stageService.findByIdDTO(id);
    }

    @GetMapping(value="entreprise/{id_entreprise}")
    public List<StageDTO> findStageByEntrepriseId(@PathVariable(name="id_entreprise") int id) throws FonctionnelException {
        return stageService.findStagesByEntrepriseId(id);
    }

    @PostMapping
    public StageDTO ajoutStage(@RequestBody StageDTO stage) {
        return stageService.create(stage);

    }

}
