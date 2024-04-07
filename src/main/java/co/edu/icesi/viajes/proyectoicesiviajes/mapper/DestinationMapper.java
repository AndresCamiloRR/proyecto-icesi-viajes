package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Destination;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DestinationMapper {

    List<Destination> toDestination(List<DestinationDTO> destinationDTOList);
    List<DestinationDTO> toDestinationDTO(List<Destination> destinationList);

}
