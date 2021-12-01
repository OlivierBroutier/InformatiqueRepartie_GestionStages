package com.example.ir.service;

import com.example.ir.entity.Professeur;
import com.example.ir.repository.ProfesseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurService {

    private final ProfesseurRepository professeurRepository;

    public ProfesseurService(ProfesseurRepository professeurRepository) {
        this.professeurRepository = professeurRepository;
    }

    public List<Professeur> findAll() {
        return professeurRepository.findAll();
    }

    public Optional<Professeur> findByLoginAndPassword(String login, String password) {
        return professeurRepository.findByLoginAndMdp(login, password);
    }

}
