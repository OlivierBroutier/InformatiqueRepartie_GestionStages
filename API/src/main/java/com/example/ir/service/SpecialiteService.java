package com.example.ir.service;

import com.example.ir.dto.SpecialiteDTO;
import com.example.ir.entity.Specialite;
import com.example.ir.mapper.SpecialiteMapper;
import com.example.ir.repository.SpecialiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialiteService {

    private final SpecialiteRepository specialiteRepository;
    private final SpecialiteMapper specialiteMapper;

    public SpecialiteService(SpecialiteRepository specialiteRepository, SpecialiteMapper specialiteMapper) {
        this.specialiteRepository = specialiteRepository;
        this.specialiteMapper = specialiteMapper;
    }

    public List<Specialite> findAll() {
        return specialiteRepository.findAll();
    }

    public List<SpecialiteDTO> findAllDTO() {
        return specialiteMapper.toListDTO(findAll());
    }

}
