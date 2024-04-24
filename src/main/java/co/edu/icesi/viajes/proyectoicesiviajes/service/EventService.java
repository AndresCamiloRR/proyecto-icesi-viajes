package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Event;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.User;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.EventDTO;

import java.sql.Date;
import java.util.List;

public interface EventService extends GenericService<EventDTO, Long>{

    List<EventDTO> findByEntity(String entity);

    List<EventDTO> findByType(String type);

    List<EventDTO> findByIdUser(User idUser);

    List<EventDTO> findByIdEntity(String idEntity);

    List<EventDTO> findByDate(Date date);

}
