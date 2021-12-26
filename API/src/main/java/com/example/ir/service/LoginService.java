package com.example.ir.service;

import com.example.ir.config.ErrorEnum;
import com.example.ir.config.FonctionnelException;
import com.example.ir.dto.EtudiantDTO;
import com.example.ir.dto.ProfesseurDTO;
import com.example.ir.dto.LoginDTO;
import com.example.ir.dto.UtilisateurDTO;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final EtudiantService etudiantService;
    private final ProfesseurService professeurService;

    public LoginService(EtudiantService etudiantService, ProfesseurService professeurService) {
        this.etudiantService = etudiantService;
        this.professeurService = professeurService;
    }

    public UtilisateurDTO login(LoginDTO loginDTO) throws FonctionnelException {
        if (loginDTO.getStatut().equals("E")) {
            EtudiantDTO etudiantDTO = etudiantService.findByLoginAndPassword(loginDTO.getLogin(), loginDTO.getMdp());
            return new UtilisateurDTO(etudiantDTO);
        } else if (loginDTO.getStatut().equals("P")) {
            ProfesseurDTO professeurDTO = professeurService.findByLoginAndPassword(loginDTO.getLogin(), loginDTO.getMdp());
            return new UtilisateurDTO(professeurDTO);
        }

        throw new FonctionnelException(ErrorEnum.USER_WITH_LOGIN_NOT_FOUND);
    }

}
