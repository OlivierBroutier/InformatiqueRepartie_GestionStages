package com.example.ir.mapper;

import com.example.ir.dto.EtudiantDTO;
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
                ClasseMapper.class,
                StageMapper.class
        }
)
@Named("Etudiant")
public interface EtudiantMapper {

    @Named("DTO")
    @Mapping(target = "stages", qualifiedByName = { "Stage", "ListLightDTO" })
    EtudiantDTO toDTO(Etudiant etudiant);

    @Named("ListDTO")
    @IterableMapping(qualifiedByName = "DTO")
    List<EtudiantDTO> toListDTO(List<Etudiant> etudiants);

    @Named("LightDTO")
    @Mapping(target = "stages", ignore = true)
    EtudiantDTO toLightDTO(Etudiant etudiant);

    @Named("ListLightDTO")
    @IterableMapping(qualifiedByName = "LightDTO")
    List<EtudiantDTO> toListLightDTO(List<Etudiant> etudiants);



    @Named("BO")
    @Mapping(target = "mdp", ignore = true)
    @Mapping(target = "stages", qualifiedByName = { "Stage", "ListLightBO" })
    Etudiant toBO(EtudiantDTO etudiant);

    @Named("ListBO")
    @IterableMapping(qualifiedByName = "BO")
    List<Etudiant> toListBO(List<EtudiantDTO> etudiants);

}
