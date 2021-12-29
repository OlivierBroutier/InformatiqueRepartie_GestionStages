package com.example.ir.service;

import com.example.ir.config.ErrorEnum;
import com.example.ir.config.FonctionnelException;
import com.example.ir.dto.EtudiantDTO;
import com.example.ir.entity.Etudiant;
import com.example.ir.mapper.EtudiantMapper;
import com.example.ir.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final EtudiantMapper etudiantMapper;

    public EtudiantService(EtudiantRepository etudiantRepository, EtudiantMapper etudiantMapper) {
        this.etudiantRepository = etudiantRepository;
        this.etudiantMapper = etudiantMapper;
    }

    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    public List<EtudiantDTO> findAllDTO() {
        return etudiantMapper.toListDTO(findAll());
    }

    public Etudiant findById(Integer id) throws FonctionnelException {
        Optional<Etudiant> oEtudiant = etudiantRepository.findById(id);
        if (oEtudiant.isEmpty()) {
            throw new FonctionnelException(ErrorEnum.ETUDIANT_NOT_FOUND);
        }

        return oEtudiant.get();
    }

    public EtudiantDTO findByIdDTO(Integer id) throws FonctionnelException {
        return etudiantMapper.toDTO(findById(id));
    }

    public EtudiantDTO create(EtudiantDTO etudiantDTO) {
        Etudiant etudiant = etudiantMapper.toBO(etudiantDTO);
        etudiant.setEnActivite(true);
        return etudiantMapper.toDTO(etudiantRepository.save(etudiant));
    }

    public EtudiantDTO findByLoginAndPassword(String login, String password) throws FonctionnelException {
        Optional<Etudiant> oEtudiant = etudiantRepository.findByLoginAndMdp(login, password);
        if (oEtudiant.isEmpty()) {
            throw new FonctionnelException(ErrorEnum.ETUDIANT_WITH_LOGIN_NOT_FOUND);
        }
        return etudiantMapper.toDTO(oEtudiant.get());
    }

    public boolean delete(Integer id) {
       etudiantRepository.deleteById(id);
       return true;
    }
}
