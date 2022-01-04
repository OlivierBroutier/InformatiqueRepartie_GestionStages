package com.example.ir.mapper;

import com.example.ir.dto.StageDTO;
import com.example.ir.entity.Stage;
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
                EtudiantMapper.class,
                ProfesseurMapper.class,
                EntrepriseMapper.class
        }
)
@Named("Stage")
public interface StageMapper {

    @Named("DTO")
    @Mapping(target = "etudiant", qualifiedByName = { "Etudiant", "LightDTO" })
    @Mapping(target = "professeur", qualifiedByName = { "Professeur", "LightDTO" })
    @Mapping(target = "entreprise", qualifiedByName = { "Entreprise", "LightDTO" })
    StageDTO toDTO(Stage stage);

    @Named("ListDTO")
    @IterableMapping(qualifiedByName = "DTO")
    List<StageDTO> toListDTO(List<Stage> stages);

    @Named("LightDTO")
    @Mapping(target = "etudiant", qualifiedByName = { "Etudiant", "LightDTO" })
    @Mapping(target = "professeur", qualifiedByName = { "Professeur", "LightDTO" })
    @Mapping(target = "entreprise", qualifiedByName = { "Entreprise", "LightDTO" })
    StageDTO toLightDTO(Stage stage);

    @Named("ListLightDTO")
    @IterableMapping(qualifiedByName = "LightDTO")
    List<StageDTO> toListLightDTO(List<Stage> stages);



    @Named("BO")
    @Mapping(target = "etudiant", qualifiedByName = { "Etudiant", "BO" })
    @Mapping(target = "professeur", qualifiedByName = { "Professeur", "BO" })
    @Mapping(target = "entreprise", qualifiedByName = { "Entreprise", "BO" })
    @Mapping(target = "missions", ignore = true)
    Stage toBO(StageDTO stage);

    @Named("ListBO")
    @IterableMapping(qualifiedByName = "BO")
    List<Stage> toListBO(List<StageDTO> stages);

    @Named("LightBO")
    @Mapping(target = "etudiant", ignore = true)
    @Mapping(target = "professeur", ignore = true)
    @Mapping(target = "entreprise", ignore = true)
    @Mapping(target = "missions", ignore = true)
    Stage toLightBO(StageDTO stage);

    @Named("ListLightBO")
    @IterableMapping(qualifiedByName = "LightBO")
    List<Stage> toListLightBO(List<StageDTO> stages);

}
