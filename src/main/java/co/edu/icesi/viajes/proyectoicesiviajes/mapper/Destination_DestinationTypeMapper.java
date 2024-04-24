package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Destination_DestinationType;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.Destination_DestinationTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface Destination_DestinationTypeMapper {

    @Mapping(source = "destinationType.id", target = "destinationType")
    @Mapping(source = "destination.id", target = "destination")
    Destination_DestinationTypeDTO toDestination_DestinationTypeDTO(Destination_DestinationType entity);

    @Mapping(source = "destinationType", target = "destinationType.id")
    @Mapping(source = "destination", target = "destination.id")
    Destination_DestinationType toDestination_DestinationType(Destination_DestinationTypeDTO dto);

    @Mapping(source = "destinationType.id", target = "destinationType")
    @Mapping(source = "destination.id", target = "destination")
    List<Destination_DestinationTypeDTO> toDestination_DestinationTypeDTO(List<Destination_DestinationType> entityList);

    @Mapping(source = "destinationType", target = "destinationType.id")
    @Mapping(source = "destination", target = "destination.id")
    List<Destination_DestinationType> toDestination_DestinationType(List<Destination_DestinationTypeDTO> dtoList);

}