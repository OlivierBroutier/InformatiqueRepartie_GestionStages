package com.example.ir.rest;

import com.example.ir.config.FonctionnelException;
import com.example.ir.dto.StageDTO;
import com.example.ir.service.StageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/stage")
public class StageController {

    private final StageService stageService;

    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    @GetMapping
    public List<StageDTO> findAll() {
        return stageService.findAllDTO();
    }

    @GetMapping(value= "/{id}")
    public StageDTO findStageById(@PathVariable(name = "id") int id) throws FonctionnelException {
        return stageService.findByIdDTO(id);
    }

    @GetMapping(value="etudiant/{idEtudiant}")
    public List<StageDTO> findAllByEtudiant(@PathVariable(name="idEtudiant") int id) throws FonctionnelException {
        return stageService.findAllByEtudiant(id);
    }

    @PostMapping
    public StageDTO ajoutStage(@RequestBody StageDTO stage) {
        return stageService.create(stage);
    }

    @PutMapping
    public StageDTO modifStage(@RequestBody StageDTO stage){
        return stageService.update(stage);
    }

    @DeleteMapping(value="/{id}")
    public Boolean deleteStage(@PathVariable(name = "id") int id) {
        return stageService.delete(id);
    }

}
