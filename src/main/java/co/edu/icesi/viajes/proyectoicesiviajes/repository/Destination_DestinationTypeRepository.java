package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Destination_DestinationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Destination_DestinationTypeRepository extends JpaRepository<Destination_DestinationType, Long> {

    List<Destination_DestinationType> findByDestinationType_Id(Long destinationTypeId);

    List<Destination_DestinationType> findByDestination_Id(Long destinationId);

    Destination_DestinationType findByDestinationType_IdAndDestination_Id(Long destinationType_id, Long destination_id);

    void deleteById(Long id);

    void deleteByDestination_Id(Long destination_id);

    void deleteByDestinationType_Id(Long destinationType_id);

}
