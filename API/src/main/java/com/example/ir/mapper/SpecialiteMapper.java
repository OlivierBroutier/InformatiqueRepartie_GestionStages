package com.example.ir.mapper;

import com.example.ir.dto.SpecialiteDTO;
import com.example.ir.entity.Specialite;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface SpecialiteMapper {

    SpecialiteDTO toDTO(Specialite specialite);

    List<SpecialiteDTO> toListDTO(List<Specialite> specialites);

    Specialite toBO(SpecialiteDTO specialite);

    List<Specialite> toListBO(List<SpecialiteDTO> specialites);

}
