package com.example.ir.mapper;

import com.example.ir.entity.Etudiant;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {
                ClasseMapper.class
        }
)
@Named("Etudiant")
public interface EtudiantMapper {

    @Named("DTO")
    com.example.ir.dto.EtudiantDTO toDTO(Etudiant etudiant);

    @Named("ListDTO")
    @IterableMapping(qualifiedByName = "DTO")
    List<com.example.ir.dto.EtudiantDTO> toListDTO(List<Etudiant> etudiants);



    @Named("BO")
    @Mapping(target = "mdp", ignore = true)
    Etudiant toBO(com.example.ir.dto.EtudiantDTO etudiant);

    @Named("ListBO")
    @IterableMapping(qualifiedByName = "BO")
    List<Etudiant> toListBO(List<com.example.ir.dto.EtudiantDTO> etudiants);

}
