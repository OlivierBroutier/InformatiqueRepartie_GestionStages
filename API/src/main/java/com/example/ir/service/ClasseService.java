package com.example.ir.service;

import com.example.ir.dto.ClasseDTO;
import com.example.ir.entity.Classe;
import com.example.ir.mapper.ClasseMapper;
import com.example.ir.repository.ClasseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClasseService {

    private final ClasseRepository classeRepository;
    private final ClasseMapper classeMapper;

    public ClasseService(ClasseRepository classeRepository, ClasseMapper classeMapper) {
        this.classeRepository = classeRepository;
        this.classeMapper = classeMapper;
    }

    public List<Classe> findAll() {
        return classeRepository.findAll();
    }

    public List<ClasseDTO> findAllDTO() {
        return classeMapper.toListDTO(findAll());
    }
}

