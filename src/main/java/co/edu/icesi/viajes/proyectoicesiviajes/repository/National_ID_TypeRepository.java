package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.National_ID_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface National_ID_TypeRepository extends JpaRepository<National_ID_Type, Long> {

    List<National_ID_Type> findByCode(String code);

    List<National_ID_Type> findByName(String name);

    List<National_ID_Type> findByStatus(String status);

    @Modifying
    @Query("UPDATE National_ID_Type n SET n.status = 'inactive' WHERE n.id = ?1")
    void deleteById(Long id);


}
