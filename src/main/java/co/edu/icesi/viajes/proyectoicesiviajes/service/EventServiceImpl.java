package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Event;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.User;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.EventDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.EventMapper;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class EventServiceImpl implements EventService{

    @Autowired
    EventRepository repository;

    @Autowired
    EventMapper mapper;


    @Override
    public List<EventDTO> findByEntity(String entity) {
        List<Event> list = repository.findByEntity(entity);
        return mapper.toEventDTO(list);
    }

    @Override
    public List<EventDTO> findByType(String type) {
        List<Event> list = repository.findByType(type);
        return mapper.toEventDTO(list);
    }

    @Override
    public List<EventDTO> findByIdUser(User idUser) {
        List<Event> list = repository.findByIdUser(idUser);
        return mapper.toEventDTO(list);
    }

    @Override
    public List<EventDTO> findByIdEntity(String idEntity) {
        List<Event> list = repository.findByIdEntity(idEntity);
        return mapper.toEventDTO(list);
    }

    @Override
    public List<EventDTO> findByDate(Date date) {
        List<Event> list = repository.findByDate(date);
        return mapper.toEventDTO(list);
    }

    @Override
    public List<EventDTO> findAll() {
        List<Event> list = repository.findAll();
        return mapper.toEventDTO(list);
    }

    @Override
    public EventDTO findById(Long id) throws Exception{
        try {
            Event entity = repository.findById(id).get();
            return mapper.toEventDTO(entity);
        }catch (Exception e){
            throw new Exception("La entidad no fue encontrada");
        }
    }

    @Override
    public EventDTO save(EventDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            Event event = mapper.toEvent(entity);
            return mapper.toEventDTO(repository.save(event));
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public EventDTO update(EventDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            Event event = mapper.toEvent(entity);
            return mapper.toEventDTO(repository.save(event));
        }else{
            throw new Exception("La entidad no existe en el sistema");
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }else{
            throw new Exception("La entidad no existe en el sistema");
        }
    }

    @Override
    public void validate(EventDTO entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }
}
