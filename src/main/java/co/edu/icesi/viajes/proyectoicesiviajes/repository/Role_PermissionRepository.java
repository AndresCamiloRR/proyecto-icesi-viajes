package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Role_Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Role_PermissionRepository extends JpaRepository<Role_Permission, Long> {

    List<Role_Permission> findByRol_Id(Long roleId);

    List<Role_Permission> findByPermission_Id(Long permissionId);

    Role_Permission findByRol_IdAndPermission_Id(Long rol_id, Long permission_id);

    void deleteByRol_Id(Long roleId);

    void deleteByPermission_Id(Long permissionId);

}
