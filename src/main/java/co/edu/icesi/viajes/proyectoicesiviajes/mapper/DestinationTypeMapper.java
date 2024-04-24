package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.DestinationType;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface DestinationTypeMapper {

    List<DestinationType> toDestinationType(List<DestinationTypeDTO> destinationTypeDTOList);
    List<DestinationTypeDTO> toDestinationTypeDTO(List<DestinationType> destinationTypeList);

    DestinationType toDestinationType(DestinationTypeDTO destinationTypeDTO);
    DestinationTypeDTO toDestinationTypeDTO(DestinationType destinationType);

}
