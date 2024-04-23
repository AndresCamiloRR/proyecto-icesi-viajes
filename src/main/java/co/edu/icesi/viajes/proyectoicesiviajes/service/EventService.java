package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Event;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.User;

import java.sql.Date;
import java.util.List;

public interface EventService extends GenericService<Event, Long>{

    List<Event> findByEntity(String entity);

    List<Event> findByType(String type);

    List<Event> findByIdUser(User idUser);

    List<Event> findByIdEntity(String idEntity);

    List<Event> findByDate(Date date);

}
