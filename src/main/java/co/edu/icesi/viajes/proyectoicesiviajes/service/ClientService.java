package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Client;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.National_ID_Type;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ClientService extends GenericService<Client, Long>{

    List<Client> findByNameContaining(String name);

    List<Client> findBySex(String sex);

    List<Client> findByStatus(String status);

    List<Client> findByTypeNID_Id(Long typeNID_id);

    List<Client> findByBirthDate(Date birthDate);

}
