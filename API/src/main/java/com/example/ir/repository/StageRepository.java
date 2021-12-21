package com.example.ir.repository;

import com.example.ir.entity.Entreprise;
import com.example.ir.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StageRepository extends JpaRepository<Stage, Integer> {

    List<Stage> findAllByEntreprise(Entreprise entreprise);

}
