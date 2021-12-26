package com.example.ir.mapper;

import com.example.ir.dto.EntrepriseDTO;
import com.example.ir.dto.ProfesseurDTO;
import com.example.ir.entity.Entreprise;
import com.example.ir.entity.Professeur;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
@Named("Entreprise")
public interface EntrepriseMapper {

    @Named("DTO")
    EntrepriseDTO toDTO(Entreprise entreprise);

    @Named("ListDTO")
    @IterableMapping(qualifiedByName = "DTO")
    List<EntrepriseDTO> toListDTO(List<Entreprise> entreprises);

    @Named("LightDTO")
    EntrepriseDTO toLightDTO(Entreprise entreprise);

    @Named("ListLightDTO")
    @IterableMapping(qualifiedByName = "LightDTO")
    List<EntrepriseDTO> toListLightDTO(List<Entreprise> entreprises);



    @Named("BO")
    Entreprise toBO(EntrepriseDTO entreprise);

    @Named("ListBO")
    @IterableMapping(qualifiedByName = "BO")
    List<Entreprise> toListBO(List<EntrepriseDTO> entreprises);

}
