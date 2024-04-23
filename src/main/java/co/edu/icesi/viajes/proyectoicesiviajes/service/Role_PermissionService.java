package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Role_Permission;

import java.util.List;

public interface Role_PermissionService extends GenericService<Role_Permission, Long> {

    List<Role_Permission> findByRol_Id(Long roleId);

    List<Role_Permission> findByPermission_Id(Long permissionId);

    Role_Permission findByRol_IdAndPermission_Id(Long rol_id, Long permission_id);

    void deleteByRol_Id(Long roleId);

    void deleteByPermission_Id(Long permissionId);

}
