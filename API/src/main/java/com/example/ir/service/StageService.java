package com.example.ir.service;

import com.example.ir.config.ErrorEnum;
import com.example.ir.config.FonctionnelException;
import com.example.ir.dto.StageDTO;
import com.example.ir.entity.Entreprise;
import com.example.ir.entity.Mission;
import com.example.ir.entity.Stage;
import com.example.ir.mapper.StageMapper;
import com.example.ir.repository.MissionRepository;
import com.example.ir.repository.StageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StageService {

    private final StageRepository stageRepository;
    private final StageMapper stageMapper;
    private final EntrepriseService entrepriseService;
    private final MissionRepository missionRepository;

    public StageService(StageRepository stageRepository, StageMapper stageMapper, EntrepriseService entrepriseService, MissionRepository missionRepository) {
        this.stageRepository = stageRepository;
        this.stageMapper = stageMapper;
        this.entrepriseService = entrepriseService;
        this.missionRepository = missionRepository;
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

    @Transactional(rollbackFor = Exception.class)
    public StageDTO create(StageDTO stageDTO) {
        Stage stage = stageMapper.toBO(stageDTO);
        List<Mission> missions = new ArrayList<>(stage.getMissions());

        stage.getMissions().clear();
        Stage savedStage = stageRepository.save(stage);

        missions.forEach(mission -> mission.setStage(savedStage));
        missions = missionRepository.saveAll(missions);

        savedStage.getMissions().addAll(missions);
        return stageMapper.toLightDTO(savedStage);
    }

    @Transactional(rollbackFor = Exception.class)
    public StageDTO update(StageDTO stage) {
        stage.getMissions().forEach(mission -> mission.setStage(stage));
        return stageMapper.toDTO(stageRepository.save(stageMapper.toBO(stage)));
    }

    public Boolean delete(Integer id) {
        stageRepository.deleteById(id);
        return true;
    }
}
