package com.example.ir.mapper;

import com.example.ir.dto.EntrepriseDTO;
import com.example.ir.entity.Entreprise;
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
                SpecialiteMapper.class
        }
)
@Named("Entreprise")
public interface EntrepriseMapper {

    @Named("DTO")
    @Mapping(target = "stages", qualifiedByName = { "Stage", "ListLightDTO" })
    EntrepriseDTO toDTO(Entreprise entreprise);

    @Named("ListDTO")
    @IterableMapping(qualifiedByName = "DTO")
    List<EntrepriseDTO> toListDTO(List<Entreprise> entreprises);

    @Named("LightDTO")
    @Mapping(target = "stages", ignore = true)
    EntrepriseDTO toLightDTO(Entreprise entreprise);

    @Named("ListLightDTO")
    @IterableMapping(qualifiedByName = "LightDTO")
    List<EntrepriseDTO> toListLightDTO(List<Entreprise> entreprises);



    @Named("BO")
    @Mapping(target = "stages", qualifiedByName = { "Stage", "ListLightBO" })
    Entreprise toBO(EntrepriseDTO entreprise);

    @Named("ListBO")
    @IterableMapping(qualifiedByName = "BO")
    List<Entreprise> toListBO(List<EntrepriseDTO> entreprises);

    @Named("LightBO")
    @Mapping(target = "stages", ignore = true)
    Entreprise toLightBO(EntrepriseDTO entreprise);

    @Named("ListLightBO")
    @IterableMapping(qualifiedByName = "LightBO")
    List<Entreprise> toListLightBO(List<EntrepriseDTO> entreprises);

}
