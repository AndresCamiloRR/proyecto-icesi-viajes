package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Role;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.RoleDTO;

import java.util.List;

public interface RoleService extends GenericService<RoleDTO, Long> {

    List<RoleDTO> findByName(String name);

    List<RoleDTO> findByStatus(String status);

}
