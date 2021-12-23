package com.example.ir.repository;

import com.example.ir.entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecialiteRepository extends JpaRepository<Specialite, Integer> {

}
