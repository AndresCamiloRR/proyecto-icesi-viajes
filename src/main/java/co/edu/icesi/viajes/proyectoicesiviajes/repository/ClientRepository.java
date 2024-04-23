package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByNameContaining(String name);

    List<Client> findBySex(String sex);

    List<Client> findByStatus(String status);

    List<Client> findByTypeNID_Id(Long typeNID_id);

    List<Client> findByBirthDate(Date birthDate);

    @Modifying
    @Query("UPDATE Client c SET c.status = 'inactive' WHERE c.id = ?1")
    void deleteById(Long id);

}
