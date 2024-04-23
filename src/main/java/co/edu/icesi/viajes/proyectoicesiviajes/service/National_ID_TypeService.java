package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.National_ID_Type;

import java.util.List;

public interface National_ID_TypeService extends GenericService<National_ID_Type, Long>{

    List<National_ID_Type> findByCode(String code);

    List<National_ID_Type> findByName(String name);

    List<National_ID_Type> findByStatus(String status);

}
