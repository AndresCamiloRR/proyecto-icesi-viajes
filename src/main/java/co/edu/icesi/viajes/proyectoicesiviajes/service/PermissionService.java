package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Permission;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PermissionDTO;

import java.util.List;

public interface PermissionService extends GenericService<PermissionDTO, Long> {

    List<PermissionDTO> findByName(String name);

    List<PermissionDTO> findByStatus(String status);

}
