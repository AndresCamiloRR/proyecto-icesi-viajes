package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByName(String name);

    List<Role> findByStatus(String status);

    @Modifying
    @Query("UPDATE Role r SET r.status = 'inactive' WHERE r.id = ?1")
    void deleteById(Long id);
}
