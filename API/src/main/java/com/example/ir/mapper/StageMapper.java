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
    @Mapping(target = "etudiant", qualifiedByName = { "Etudiant", "DTO" })
    @Mapping(target = "professeur", qualifiedByName = { "Professeur", "DTO" })
    @Mapping(target = "entreprise", qualifiedByName = { "Entreprise", "DTO" })
    StageDTO toDTO(Stage stage);

    @Named("ListDTO")
    @IterableMapping(qualifiedByName = "DTO")
    List<StageDTO> toListDTO(List<Stage> stages);

    @Named("LightDTO")
    @Mapping(target = "etudiant", ignore = true)
    @Mapping(target = "professeur", qualifiedByName = { "Professeur", "DTO" })
    @Mapping(target = "entreprise", qualifiedByName = { "Entreprise", "DTO" })
    StageDTO toLightDTO(Stage stage);

    @Named("ListLightDTO")
    @IterableMapping(qualifiedByName = "LightDTO")
    List<StageDTO> toListLightDTO(List<Stage> stages);



    @Named("BO")
    @Mapping(target = "etudiant", qualifiedByName = "BO")
    @Mapping(target = "professeur", qualifiedByName = "BO")
    @Mapping(target = "entreprise", qualifiedByName = "BO")
    Stage toBO(StageDTO stage);

    @Named("ListBO")
    @IterableMapping(qualifiedByName = "BO")
    List<Stage> toListBO(List<StageDTO> stages);

}
