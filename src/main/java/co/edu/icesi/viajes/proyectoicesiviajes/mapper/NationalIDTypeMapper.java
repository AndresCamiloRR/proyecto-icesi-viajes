package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.National_ID_Type;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.National_ID_TypeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface NationalIDTypeMapper {

    List<National_ID_Type> toNational_ID_Type(List<National_ID_TypeDTO> nationalIdTypeDTOList);
    List<National_ID_TypeDTO> toNational_ID_TypeDTO(List<National_ID_Type> nationalIdTypeList);

}
