package com.example.ir.service;

import com.example.ir.config.ErrorEnum;
import com.example.ir.config.FonctionnelException;
import com.example.ir.dto.ProfesseurDTO;
import com.example.ir.entity.Professeur;
import com.example.ir.mapper.ProfesseurMapper;
import com.example.ir.repository.ProfesseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurService {

    private final ProfesseurRepository professeurRepository;
    private final ProfesseurMapper professeurMapper;

    public ProfesseurService(ProfesseurRepository professeurRepository, ProfesseurMapper professeurMapper) {
        this.professeurRepository = professeurRepository;
        this.professeurMapper = professeurMapper;
    }

    public List<Professeur> findAll() {
        return professeurRepository.findAll();
    }

    public List<ProfesseurDTO> findAllDTO() {
        return professeurMapper.toListDTO(findAll());
    }

    public Professeur findById(Integer id) throws FonctionnelException {
        Optional<Professeur> oProfesseur = professeurRepository.findById(id);
        if (oProfesseur.isEmpty()) {
            throw new FonctionnelException(ErrorEnum.PROFESSEUR_NOT_FOUND);
        }
        return oProfesseur.get();
    }

    public ProfesseurDTO findByLoginAndPassword(String login, String password) throws FonctionnelException {
        Optional<Professeur> oProfesseur = professeurRepository.findByLoginAndMdp(login, password);
        if (oProfesseur.isEmpty()) {
            throw new FonctionnelException(ErrorEnum.PROFESSEUR_WITH_LOGIN_NOT_FOUND);
        }
        return professeurMapper.toDTO(oProfesseur.get());
    }

}
