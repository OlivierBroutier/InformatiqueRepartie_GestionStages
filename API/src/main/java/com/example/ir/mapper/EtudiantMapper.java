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
                StageMapper.class,
                MessageMapper.class
        }
)
@Named("Etudiant")
public interface EtudiantMapper {

    @Named("DTO")
    @Mapping(target = "mdp", ignore = true)
    @Mapping(target = "stages", qualifiedByName = { "Stage", "ListLightDTO" })
    @Mapping(target = "messagesEnvoyes", source = "messagesEnvoyes", qualifiedByName = { "Message", "ListDTO" })
    @Mapping(target = "messagesRecus", source = "destinatairesEtudiants", qualifiedByName = { "Message", "ListEtudiantDTO" })
    EtudiantDTO toDTO(Etudiant etudiant);

    @Named("ListDTO")
    @IterableMapping(qualifiedByName = "DTO")
    List<EtudiantDTO> toListDTO(List<Etudiant> etudiants);

    @Named("LightDTO")
    @Mapping(target = "mdp", ignore = true)
    @Mapping(target = "stages", ignore = true)
    @Mapping(target = "messagesEnvoyes", ignore = true)
    @Mapping(target = "messagesRecus", ignore = true)
    EtudiantDTO toLightDTO(Etudiant etudiant);

    @Named("ListLightDTO")
    @IterableMapping(qualifiedByName = "LightDTO")
    List<EtudiantDTO> toListLightDTO(List<Etudiant> etudiants);



    @Named("BO")
    @Mapping(target = "stages", qualifiedByName = { "Stage", "ListLightBO" })
    @Mapping(target = "messagesEnvoyes", ignore = true)
    @Mapping(target = "destinatairesEtudiants", ignore = true)
    Etudiant toBO(EtudiantDTO etudiant);

    @Named("ListBO")
    @IterableMapping(qualifiedByName = "BO")
    List<Etudiant> toListBO(List<EtudiantDTO> etudiants);

}
