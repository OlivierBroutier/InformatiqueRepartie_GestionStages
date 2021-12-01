package com.example.ir.service;

import com.example.ir.config.ErrorEnum;
import com.example.ir.entity.Etudiant;
import com.example.ir.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    public Etudiant findById(Integer id) throws Exception {
        Optional<Etudiant> oEtudiant = etudiantRepository.findById(id);
        if (oEtudiant.isEmpty()) {
            throw new Exception(ErrorEnum.ETUDIANT_NOT_FOUND.getMessage());
        }

        return oEtudiant.get();
    }

}
