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
                StageMapper.class,
                MessageMapper.class
        }
)
@Named("Professeur")
public interface ProfesseurMapper {

    @Named("DTO")
    @Mapping(target = "mdp", ignore = true)
    @Mapping(target = "stages", qualifiedByName = { "Stage", "ListLightDTO" })
    @Mapping(target = "messagesEnvoyes", source = "messagesEnvoyes", qualifiedByName = { "Message", "ListDTO" })
    @Mapping(target = "messagesRecus", source = "destinatairesProfesseurs", qualifiedByName = { "Message", "ListProfesseurDTO" })
    ProfesseurDTO toDTO(Professeur professeur);

    @Named("ListDTO")
    @IterableMapping(qualifiedByName = "DTO")
    List<ProfesseurDTO> toListDTO(List<Professeur> professeurs);

    @Named("LightDTO")
    @Mapping(target = "mdp", ignore = true)
    @Mapping(target = "stages", ignore = true)
    @Mapping(target = "messagesEnvoyes", ignore = true)
    @Mapping(target = "messagesRecus", ignore = true)
    ProfesseurDTO toLightDTO(Professeur professeur);

    @Named("ListLightDTO")
    @IterableMapping(qualifiedByName = "LightDTO")
    List<ProfesseurDTO> toListLightDTO(List<Professeur> professeurs);



    @Named("BO")
    @Mapping(target = "stages", qualifiedByName = { "Stage", "ListLightBO" })
    @Mapping(target = "profClasseAssoc", ignore = true)
    @Mapping(target = "messagesEnvoyes", ignore = true)
    @Mapping(target = "destinatairesProfesseurs", ignore = true)
    Professeur toBO(ProfesseurDTO professeur);

    @Named("ListBO")
    @IterableMapping(qualifiedByName = "BO")
    List<Professeur> toListBO(List<ProfesseurDTO> professeurs);

}
