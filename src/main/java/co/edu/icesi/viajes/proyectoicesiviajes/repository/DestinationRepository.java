package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Destination;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.DestinationType;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationTopDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationTypeDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationTypeSimpleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

    List<Destination> findByCode(String code);

    List<Destination> findByName(String name);

    List<Destination> findByByLand(String byLand);

    List<Destination> findByBySea(String bySea);

    List<Destination> findByByAir(String byAir);

    List<Destination> findByStatus(String status);

    @Modifying
    @Query("UPDATE Destination d SET d.status = 'inactive' WHERE d.id = ?1")
    void deleteById(Long id);

    @Query(nativeQuery = true)
    List<DestinationTypeSimpleDTO> getTypes(long id);

}

