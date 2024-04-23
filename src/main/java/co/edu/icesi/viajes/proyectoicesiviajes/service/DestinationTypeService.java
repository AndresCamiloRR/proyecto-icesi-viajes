package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.DestinationType;

import java.util.List;

public interface DestinationTypeService extends GenericService<DestinationType, Long> {

    List<DestinationType> findByCode(String code);

    List<DestinationType> findByName(String name);

    List<DestinationType> findByStatus(String status);

}
