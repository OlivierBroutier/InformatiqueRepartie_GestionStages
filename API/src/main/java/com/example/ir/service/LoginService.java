package com.example.ir.service;

import com.example.ir.config.ErrorEnum;
import com.example.ir.entity.Etudiant;
import com.example.ir.entity.Professeur;
import com.example.ir.entity.dto.LoginDTO;
import com.example.ir.entity.dto.UtilisateurDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final EtudiantService etudiantService;
    private final ProfesseurService professeurService;

    public LoginService(EtudiantService etudiantService, ProfesseurService professeurService) {
        this.etudiantService = etudiantService;
        this.professeurService = professeurService;
    }

    public UtilisateurDTO login(LoginDTO loginDTO) throws Exception {
        if (loginDTO.getStatut().equals("E")) {
            Optional<Etudiant> oEtudiant = etudiantService.findByLoginAndPassword(loginDTO.getLogin(), loginDTO.getMdp());
            if (oEtudiant.isEmpty()) {
                throw new Exception(ErrorEnum.ETUDIANT_WITH_LOGIN_NOT_FOUND.getMessage());
            }
            return new UtilisateurDTO(oEtudiant.get());
        } else if (loginDTO.getStatut().equals("P")) {
            Optional<Professeur> oProfesseur = professeurService.findByLoginAndPassword(loginDTO.getLogin(), loginDTO.getMdp());
            if (oProfesseur.isEmpty()) {
                throw new Exception(ErrorEnum.PROFESSEUR_WITH_LOGIN_NOT_FOUND.getMessage());
            }
            return new UtilisateurDTO(oProfesseur.get());
        }

        throw new Exception(ErrorEnum.USER_WITH_LOGIN_NOT_FOUND.getMessage());
    }

}
