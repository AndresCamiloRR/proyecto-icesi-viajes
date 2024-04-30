package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.dto.Destination_DestinationTypeDTO;

import java.util.List;

public interface Destination_DestinationTypeService extends GenericService<Destination_DestinationTypeDTO, Long> {

    List<Destination_DestinationTypeDTO> findByDestinationType_Id(Long destinationTypeId);

    List<Destination_DestinationTypeDTO> findByDestination_Id(Long destinationId);

    Destination_DestinationTypeDTO findByDestinationType_IdAndDestination_Id(Long destinationType_id, Long destination_id);

    void deleteByDestination_Id(Long destination_id);

    void deleteByDestinationType_Id(Long destinationType_id);

}
