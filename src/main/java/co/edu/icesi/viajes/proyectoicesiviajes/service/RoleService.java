package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Role;

import java.util.List;

public interface RoleService extends GenericService<Role, Long> {

    List<Role> findByName(String name);

    List<Role> findByStatus(String status);

}
