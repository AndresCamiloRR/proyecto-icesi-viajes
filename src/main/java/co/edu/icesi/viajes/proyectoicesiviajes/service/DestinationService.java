package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Destination;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationDTO;

import java.util.List;

public interface DestinationService extends GenericService<DestinationDTO, Long> {

    List<DestinationDTO> findByCode(String code);

    List<DestinationDTO> findByName(String name);

    List<DestinationDTO> findByByLand(String byLand);

    List<DestinationDTO> findByBySea(String bySea);

    List<DestinationDTO> findByByAir(String byAir);

    List<DestinationDTO> findByStatus(String status);

}
