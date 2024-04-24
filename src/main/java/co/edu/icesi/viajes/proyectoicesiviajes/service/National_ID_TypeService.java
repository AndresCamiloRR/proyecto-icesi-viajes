package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.National_ID_Type;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.National_ID_TypeDTO;

import java.util.List;

public interface National_ID_TypeService extends GenericService<National_ID_TypeDTO, Long>{

    List<National_ID_TypeDTO> findByCode(String code);

    List<National_ID_TypeDTO> findByName(String name);

    List<National_ID_TypeDTO> findByStatus(String status);

}
