package com.example.ir.mapper;

import com.example.ir.dto.MissionDTO;
import com.example.ir.entity.Mission;
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
@Named("Mission")
public interface MissionMapper {

    @Named("DTO")
    @Mapping(target = "stage", qualifiedByName = { "Stage", "LightDTO" })
    MissionDTO toDTO(Mission mission);

    @Named("ListDTO")
    @IterableMapping(qualifiedByName = "DTO")
    List<MissionDTO> toListDTO(List<Mission> missions);

    @Named("LightDTO")
    @Mapping(target = "stage", ignore = true)
    MissionDTO toLightDTO(Mission mission);

    @Named("ListLightDTO")
    @IterableMapping(qualifiedByName = "LightDTO")
    List<MissionDTO> toListLightDTO(List<Mission> missions);



    @Named("BO")
    @Mapping(target = "stage", qualifiedByName = { "Stage", "LightBO" })
    Mission toBO(MissionDTO mission);

    @Named("ListBO")
    @IterableMapping(qualifiedByName = "BO")
    List<Mission> toListBO(List<MissionDTO> missions);

    @Named("LightBO")
    @Mapping(target = "stage", ignore = true)
    Mission toLightBO(MissionDTO mission);

    @Named("ListLightBO")
    @IterableMapping(qualifiedByName = "BO")
    List<Mission> toListLightBO(List<MissionDTO> missions);
}
