package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Role_Permission;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.Role_PermissionDTO;

import java.util.List;

public interface Role_PermissionService extends GenericService<Role_PermissionDTO, Long> {

    List<Role_PermissionDTO> findByRole_Id(Long roleId);

    List<Role_PermissionDTO> findByPermission_Id(Long permissionId);

    Role_PermissionDTO findByRole_IdAndPermission_Id(Long rol_id, Long permission_id);

    void deleteByRole_Id(Long roleId);

    void deleteByPermission_Id(Long permissionId);

}
