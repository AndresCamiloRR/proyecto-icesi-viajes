package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Destination_DestinationType;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.Destination_DestinationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class Destination_DestinationTypeServiceImpl implements Destination_DestinationTypeService{

    @Autowired
    Destination_DestinationTypeRepository repository;

    @Override
    public List<Destination_DestinationType> findByDestinationType_Id(Long destinationTypeId) {
        return repository.findByDestinationType_Id(destinationTypeId);
    }

    @Override
    public List<Destination_DestinationType> findByDestination_Id(Long destinationId) {
        return repository.findByDestinationType_Id(destinationId);
    }

    @Override
    public Destination_DestinationType findByDestinationType_IdAndDestination_Id(Long destinationType_id, Long destination_id) {
        return repository.findByDestinationType_IdAndDestination_Id(destinationType_id, destination_id);
    }

    @Override
    public List<Destination_DestinationType> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Destination_DestinationType> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Destination_DestinationType save(Destination_DestinationType entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public Destination_DestinationType update(Destination_DestinationType entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad no existe en el sistema");
        }
    }

    @Override
    public void deleteById(Long id) throws Exception{
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }else{
            throw new Exception("La entidad no existe en el sistema");
        }
    }

    @Override
    public void deleteByDestinationType_Id(Long destinationType_id) {
        repository.deleteByDestinationType_Id(destinationType_id);
    }

    @Override
    public void deleteByDestination_Id(Long destination_id) {
        repository.deleteByDestination_Id(destination_id);
    }

    @Override
    public void validate(Destination_DestinationType entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }

}
