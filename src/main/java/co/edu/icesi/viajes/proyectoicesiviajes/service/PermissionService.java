package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Permission;

import java.util.List;

public interface PermissionService extends GenericService<Permission, Long> {

    List<Permission> findByName(String name);

    List<Permission> findByStatus(String status);

}
