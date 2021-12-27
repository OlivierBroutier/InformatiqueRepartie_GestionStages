package com.example.ir.repository;

import com.example.ir.entity.Classe;
import com.example.ir.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseRepository extends JpaRepository<Classe, Integer> {
}
