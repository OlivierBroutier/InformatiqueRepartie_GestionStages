package com.example.ir.service;

import com.example.ir.entity.Specialite;
import com.example.ir.repository.SpecialiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialiteService {

    private final SpecialiteRepository specialiteRepository;

    public SpecialiteService(SpecialiteRepository specialiteRepository) {
        this.specialiteRepository = specialiteRepository;
    }

    public List<Specialite> findAll() {
        return specialiteRepository.findAll();
    }

}
