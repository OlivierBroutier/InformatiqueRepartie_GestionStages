package com.example.ir.repository;

import com.example.ir.entity.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {

    public Optional<Professeur> findByLoginAndMdp(String login, String password);

}
