package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    List<User> findByStatus(String status);

    List<User> findByNationalID(String nationalID);

    List<User> findByName(String name);

    @Modifying
    @Query("UPDATE User u SET u.status = 'inactive' WHERE u.id = ?1")
    void deleteById(Long id);

}
