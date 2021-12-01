package com.example.ir.repository;

import com.example.ir.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    public Optional<Etudiant> findByLoginAndMdp(String login, String password);

}
