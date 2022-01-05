package com.example.ir.repository;

import com.example.ir.entity.Etudiant;
import com.example.ir.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StageRepository extends JpaRepository<Stage, Integer> {

    List<Stage> findAllByEtudiant(Etudiant etudiant);

}
