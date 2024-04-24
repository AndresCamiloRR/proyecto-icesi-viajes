package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Client;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.Event;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.ClientDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.EventDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface EventMapper {

    @Mapping(source = "idUser.id", target = "idUser")
    EventDTO toEventDTO(Event entity);

    @Mapping(source = "idUser", target = "idUser.id")
    Event toEvent(EventDTO dto);

    @Mapping(source = "idUser.id", target = "idUser")
    List<EventDTO> toEventDTO(List<Event> entityList);

    @Mapping(source = "idUser", target = "idUser.id")
    List<Event> toEvent(List<EventDTO> dtoList);

}
