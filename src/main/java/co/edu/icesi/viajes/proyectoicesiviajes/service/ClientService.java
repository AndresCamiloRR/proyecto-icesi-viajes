package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.National_ID_Type;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.ClientDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.National_ID_TypeDTO;

import java.util.Date;
import java.util.List;

public interface ClientService extends GenericService<ClientDTO, Long>{

    List<ClientDTO> findByNameContaining(String name);

    List<ClientDTO> findBySex(String sex);

    List<ClientDTO> findByStatus(String status);

    List<ClientDTO> findByTypeNID_Id(Long typeNID_id);

    List<ClientDTO> findByBirthDate(Date birthDate);


    List<ClientDTO> findAll();

}
