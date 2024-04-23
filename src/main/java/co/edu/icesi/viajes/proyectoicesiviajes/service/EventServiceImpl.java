package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Event;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.User;
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


    @Override
    public List<Event> findByEntity(String entity) {
        return repository.findByEntity(entity);
    }

    @Override
    public List<Event> findByType(String type) {
        return repository.findByType(type);
    }

    @Override
    public List<Event> findByIdUser(User idUser) {
        return repository.findByIdUser(idUser);
    }

    @Override
    public List<Event> findByIdEntity(String idEntity) {
        return repository.findByIdEntity(idEntity);
    }

    @Override
    public List<Event> findByDate(Date date) {
        return repository.findByDate(date);
    }

    @Override
    public List<Event> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Event> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Event save(Event entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public Event update(Event entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            return repository.save(entity);
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
    public void validate(Event entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }
}
