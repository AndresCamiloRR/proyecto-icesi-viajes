package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.DestinationType;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationTypeDTO;

import java.util.List;

public interface DestinationTypeService extends GenericService<DestinationTypeDTO, Long> {

    List<DestinationTypeDTO> findByCode(String code);

    DestinationTypeDTO findByName(String name);

    List<DestinationTypeDTO> findByStatus(String status);

}
