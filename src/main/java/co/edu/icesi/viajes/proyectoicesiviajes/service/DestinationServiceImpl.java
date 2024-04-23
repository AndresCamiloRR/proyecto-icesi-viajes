package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Destination;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    DestinationRepository repository;

    @Override
    public List<Destination> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<Destination> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Destination> findByByLand(String byLand) {
        return repository.findByByLand(byLand);
    }

    @Override
    public List<Destination> findByBySea(String bySea) {
        return repository.findByBySea(bySea);
    }

    @Override
    public List<Destination> findByByAir(String byAir) {
        return repository.findByByAir(byAir);
    }

    @Override
    public List<Destination> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<Destination> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Destination> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Destination save(Destination entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public Destination update(Destination entity) throws Exception {
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
    public void validate(Destination entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }
}
