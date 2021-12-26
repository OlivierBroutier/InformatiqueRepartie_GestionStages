package com.example.ir.mapper;

import com.example.ir.dto.ProfesseurDTO;
import com.example.ir.dto.StageDTO;
import com.example.ir.entity.Professeur;
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
                StageMapper.class
        }
)
@Named("Professeur")
public interface ProfesseurMapper {

    @Named("DTO")
    @Mapping(target = "stages", qualifiedByName = { "Stage", "ListLightDTO" })
    ProfesseurDTO toDTO(Professeur professeur);

    @Named("ListDTO")
    @IterableMapping(qualifiedByName = "DTO")
    List<ProfesseurDTO> toListDTO(List<Professeur> professeurs);

    @Named("LightDTO")
    @Mapping(target = "stages", ignore = true)
    ProfesseurDTO toLightDTO(Professeur professeur);

    @Named("ListLightDTO")
    @IterableMapping(qualifiedByName = "LightDTO")
    List<ProfesseurDTO> toListLightDTO(List<Professeur> professeurs);



    @Named("BO")
    @Mapping(target = "mdp", ignore = true)
    @Mapping(target = "stages", qualifiedByName = { "Stage", "ListLightBO" })
    Professeur toBO(ProfesseurDTO professeur);

    @Named("ListBO")
    @IterableMapping(qualifiedByName = "BO")
    List<Professeur> toListBO(List<ProfesseurDTO> professeurs);

}
