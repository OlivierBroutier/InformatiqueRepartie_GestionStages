package com.example.ir.service;

import com.example.ir.config.ErrorEnum;
import com.example.ir.config.FonctionnelException;
import com.example.ir.dto.StageDTO;
import com.example.ir.entity.Entreprise;
import com.example.ir.entity.Stage;
import com.example.ir.mapper.StageMapper;
import com.example.ir.repository.StageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StageService {

    private final StageRepository stageRepository;
    private final StageMapper stageMapper;
    private final EntrepriseService entrepriseService;

    public StageService(StageRepository stageRepository, StageMapper stageMapper, EntrepriseService entrepriseService) {
        this.stageRepository = stageRepository;
        this.stageMapper = stageMapper;
        this.entrepriseService = entrepriseService;
    }

    public List<Stage> findAll() {
        return stageRepository.findAll();
    }

    public List<StageDTO> findAllDTO() {
        return stageMapper.toListDTO(findAll());
    }

    public Stage findById(Integer id) throws FonctionnelException {
        Optional<Stage> o = stageRepository.findById(id);
        if (o.isEmpty()) {
            throw new FonctionnelException(ErrorEnum.STAGE_NOT_FOUND);
        }
        return o.get();
    }

    public StageDTO findByIdDTO(Integer id) throws FonctionnelException {
        return stageMapper.toDTO(findById(id));
    }

    public List<StageDTO> findStagesByEntrepriseId(Integer id) throws FonctionnelException {
        Entreprise entreprise = entrepriseService.findById(id);
        return stageMapper.toListDTO(stageRepository.findAllByEntreprise(entreprise));

    }

    public StageDTO create(StageDTO stage) {
        return stageMapper.toDTO(stageRepository.save(stageMapper.toBO(stage)));
    }

    public StageDTO update(StageDTO stage) { return stageMapper.toDTO(stageRepository.save(stageMapper.toBO(stage)));
    }

    public Boolean delete(Integer id) {
        stageRepository.deleteById(id);
        return true;
    }
}
