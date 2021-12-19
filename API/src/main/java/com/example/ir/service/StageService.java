package com.example.ir.service;

import com.example.ir.config.ErrorEnum;
import com.example.ir.config.FonctionnelException;
import com.example.ir.entity.Stage;
import com.example.ir.repository.StageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StageService {

    private StageRepository stage_repository;

    public StageService(StageRepository stage_repository) {
        this.stage_repository = stage_repository;
    }

    public List<Stage> findAll() {
        return stage_repository.findAll();
    }

    public Stage findAllById(int id) throws FonctionnelException {
        Optional<Stage> o = stage_repository.findById(id);
        if (o.isEmpty()) {
            throw new FonctionnelException(ErrorEnum.STAGE_NOT_FOUND);
        }
        return o.get();
    }
}
