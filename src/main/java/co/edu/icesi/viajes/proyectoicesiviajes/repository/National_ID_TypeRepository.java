package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.National_ID_Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface National_ID_TypeRepository extends JpaRepository<National_ID_Type, Long> {

    National_ID_Type findByStatusOrderByName(String status);

}
