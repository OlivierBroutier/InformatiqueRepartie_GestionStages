package com.example.ir.service;

import com.example.ir.bo.Stage;
import com.example.ir.config.ErrorEnum;
import com.example.ir.repository.StageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StageService {

    private final StageRepository stageRepository;

    public StageService(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public List<Stage> findAll() {
        return stageRepository.findAll();
    }

    public Stage create(Stage stage) {
        return stageRepository.save(stage);
    }

    public Stage update(Integer id, Stage stage) throws Exception {
        Optional<Stage> oStage = stageRepository.findById(id);
        if (oStage.isEmpty()) {
            throw new Exception(ErrorEnum.STAGE_NOT_FOUND.getMessage());
        }

        return stageRepository.save(stage);
    }

}
