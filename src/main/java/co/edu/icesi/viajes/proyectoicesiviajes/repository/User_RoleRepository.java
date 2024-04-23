package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.User_Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User_RoleRepository extends JpaRepository<User_Role, Long> {

    List<User_Role> findByRole_Id(Long roleId);

    List<User_Role> findByUser_Id(Long userId);

    User_Role findByRole_IdAndUser_Id(Long role_id, Long user_id);

    void deleteByRole_Id(Long roleId);

    void deleteByUser_Id(Long userId);

}
