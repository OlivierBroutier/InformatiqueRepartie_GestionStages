package com.example.ir.service;

import com.example.ir.config.FonctionnelException;
import com.example.ir.entity.Entreprise;
import com.example.ir.config.ErrorEnum;
import com.example.ir.repository.EntrepriseRepository;
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

    public Entreprise findById(Integer id) throws FonctionnelException {
        Optional<Entreprise> oEntreprise = entrepriseRepository.findById(id);
        if (oEntreprise.isEmpty()) {
            throw new FonctionnelException(ErrorEnum.ENTREPRISE_NOT_FOUND);
        }

        return oEntreprise.get();
    }

    public Entreprise create(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    public Entreprise update(Integer id, Entreprise entreprise) throws FonctionnelException {
        Optional<Entreprise> oEntreprise = entrepriseRepository.findById(id);
        if (oEntreprise.isEmpty()) {
            throw new FonctionnelException(ErrorEnum.ENTREPRISE_NOT_FOUND);
        }

        return entrepriseRepository.save(entreprise);
    }

    public boolean delete(Integer id) {
      entrepriseRepository.deleteById(id);
      return true;
    }
}
