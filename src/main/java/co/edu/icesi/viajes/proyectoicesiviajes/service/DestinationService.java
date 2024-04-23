package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Destination;

import java.util.List;

public interface DestinationService extends GenericService<Destination, Long> {

    List<Destination> findByCode(String code);

    List<Destination> findByName(String name);

    List<Destination> findByByLand(String byLand);

    List<Destination> findByBySea(String bySea);

    List<Destination> findByByAir(String byAir);

    List<Destination> findByStatus(String status);

}
