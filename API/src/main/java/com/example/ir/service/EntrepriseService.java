package com.example.ir.service;

import com.example.ir.config.FonctionnelException;
import com.example.ir.dto.EntrepriseDTO;
import com.example.ir.entity.Entreprise;
import com.example.ir.config.ErrorEnum;
import com.example.ir.mapper.EntrepriseMapper;
import com.example.ir.repository.EntrepriseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;
    private final EntrepriseMapper entrepriseMapper;

    public EntrepriseService(EntrepriseRepository entrepriseRepository, EntrepriseMapper entrepriseMapper) {
        this.entrepriseRepository = entrepriseRepository;
        this.entrepriseMapper = entrepriseMapper;
    }

    public List<EntrepriseDTO> findAll() {
        return entrepriseMapper.toListDTO(entrepriseRepository.findAll());
    }

    public Entreprise findById(Integer id) throws FonctionnelException {
        Optional<Entreprise> oEntreprise = entrepriseRepository.findById(id);
        if (oEntreprise.isEmpty()) {
            throw new FonctionnelException(ErrorEnum.ENTREPRISE_NOT_FOUND);
        }

        return oEntreprise.get();
    }

    public EntrepriseDTO findByIdDTO(Integer id) throws FonctionnelException {
        return entrepriseMapper.toDTO(findById(id));
    }

    @Transactional(rollbackFor = Exception.class)
    public EntrepriseDTO create(EntrepriseDTO entrepriseDTO) {
        Entreprise entreprise = entrepriseMapper.toBO(entrepriseDTO);
        entreprise.setEnActivite(true);



        entreprise = entrepriseRepository.save(entreprise);

        return entrepriseMapper.toDTO(entreprise);
    }

    @Transactional(rollbackFor = Exception.class)
    public EntrepriseDTO update(Integer id, EntrepriseDTO entrepriseDTO) throws FonctionnelException {
        Entreprise entreprise = findById(id);

        return entrepriseMapper.toDTO(entrepriseRepository.save(entrepriseMapper.toBO(entrepriseDTO)));
    }

    public boolean delete(Integer id) {
      entrepriseRepository.deleteById(id);
      return true;
    }
}
