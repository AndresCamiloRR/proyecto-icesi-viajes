package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.DestinationType;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.DestinationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class DestinationTypeServiceImpl implements DestinationTypeService{

    @Autowired
    DestinationTypeRepository repository;

    @Override
    public List<DestinationType> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<DestinationType> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<DestinationType> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<DestinationType> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<DestinationType> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public DestinationType save(DestinationType entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public DestinationType update(DestinationType entity) throws Exception {
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
    public void validate(DestinationType entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }
}
