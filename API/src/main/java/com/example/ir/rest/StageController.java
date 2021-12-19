package com.example.ir.rest;

import com.example.ir.config.FonctionnelException;
import com.example.ir.entity.Stage;
import com.example.ir.service.StageService;
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
@RequestMapping("/api/stage")
public class StageController {

    private final StageService stageService;

    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    @GetMapping
    public ResponseEntity<List<Stage>> findAll() {
        return ResponseEntity.ok().body(stageService.findAll());
    }

    @PostMapping
    public ResponseEntity<Stage> create(@RequestBody Stage stage) {
        return ResponseEntity.ok().body(stageService.create(stage));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Stage> update(@PathVariable(name = "id") Integer id, @RequestBody Stage stage) throws FonctionnelException {
        if (!Objects.equals(id, stage.getId())) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(stageService.update(id, stage));
    }

}
