package com.example.ir.service;

import com.example.ir.entity.Entreprise;
import com.example.ir.config.ErrorEnum;
import com.example.ir.repository.EntrepriseRepository;
import com.example.ir.repository.StageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;

    public EntrepriseService(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    public List<Entreprise> findAll() {
        return entrepriseRepository.findAll();
    }

    public Entreprise findById(Integer id) throws Exception {
        Optional<Entreprise> oEntreprise = entrepriseRepository.findById(id);
        if (oEntreprise.isEmpty()) {
            throw new Exception(ErrorEnum.ENTREPRISE_NOT_FOUND.getMessage());
        }

        return oEntreprise.get();
    }

    public Entreprise create(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    public Entreprise update(Integer id, Entreprise entreprise) throws Exception {
        Optional<Entreprise> oEntreprise = entrepriseRepository.findById(id);
        if (oEntreprise.isEmpty()) {
            throw new Exception(ErrorEnum.ENTREPRISE_NOT_FOUND.getMessage());
        }

        return entrepriseRepository.save(entreprise);
    }

}
