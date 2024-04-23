package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Destination_DestinationType;

import java.util.List;

public interface Destination_DestinationTypeService extends GenericService<Destination_DestinationType, Long> {

    List<Destination_DestinationType> findByDestinationType_Id(Long destinationTypeId);

    List<Destination_DestinationType> findByDestination_Id(Long destinationId);

    Destination_DestinationType findByDestinationType_IdAndDestination_Id(Long destinationType_id, Long destination_id);

    void deleteByDestination_Id(Long destination_id);

    void deleteByDestinationType_Id(Long destinationType_id);

}
