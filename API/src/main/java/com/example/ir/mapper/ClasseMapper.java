package com.example.ir.mapper;

import com.example.ir.dto.ClasseDTO;
import com.example.ir.entity.Classe;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
@Named("Classe")
public interface ClasseMapper {

    ClasseDTO toDTO(Classe classe);

    List<ClasseDTO> toListDTO(List<Classe> classes);

    Classe toBO(ClasseDTO classe);

}
