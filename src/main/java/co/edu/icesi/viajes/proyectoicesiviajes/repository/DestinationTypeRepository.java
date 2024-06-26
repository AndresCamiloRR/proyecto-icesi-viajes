package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.DestinationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationTypeRepository extends JpaRepository<DestinationType, Long> {

    List<DestinationType> findByCode(String code);

    List<DestinationType> findByName(String name);

    List<DestinationType> findByStatus(String status);

    @Modifying
    @Query("UPDATE DestinationType d SET d.status = 'inactive' WHERE d.id = ?1")
    void deleteById(Long id);

}
