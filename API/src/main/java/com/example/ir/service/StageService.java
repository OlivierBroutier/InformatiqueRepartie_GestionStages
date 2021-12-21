package com.example.ir.service;

import com.example.ir.config.ErrorEnum;
import com.example.ir.config.FonctionnelException;
import com.example.ir.entity.Entreprise;
import com.example.ir.entity.Stage;
import com.example.ir.repository.StageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StageService {

    private StageRepository stage_repository;
    private EntrepriseService entrepriseService;

    public StageService(StageRepository stage_repository, EntrepriseService entrepriseService) {
        this.stage_repository = stage_repository;
        this.entrepriseService = entrepriseService;
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

    public List<Stage> findStagesByEntrepriseId(int id) throws FonctionnelException {
        Entreprise entreprise = entrepriseService.findById(id);
        return stage_repository.findAllByEntreprise(entreprise);

    }
}
