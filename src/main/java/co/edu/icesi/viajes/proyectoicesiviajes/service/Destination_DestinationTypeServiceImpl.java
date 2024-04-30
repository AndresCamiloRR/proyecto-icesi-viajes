package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Destination_DestinationType;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.Destination_DestinationTypeDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.Destination_DestinationTypeMapper;
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

    @Autowired
    Destination_DestinationTypeMapper mapper;

    @Override
    public List<Destination_DestinationTypeDTO> findByDestinationType_Id(Long destinationTypeId) {
        List<Destination_DestinationType> list = repository.findByDestinationType_Id(destinationTypeId);
        return mapper.toDestination_DestinationTypeDTO(list);
    }

    @Override
    public List<Destination_DestinationTypeDTO> findByDestination_Id(Long destinationId) {
        List<Destination_DestinationType> list = repository.findByDestinationType_Id(destinationId);
        return mapper.toDestination_DestinationTypeDTO(list);
    }

    @Override
    public Destination_DestinationTypeDTO findByDestinationType_IdAndDestination_Id(Long destinationType_id, Long destination_id) {
        Destination_DestinationType entity = repository.findByDestinationType_IdAndDestination_Id(destinationType_id, destination_id);
        return mapper.toDestination_DestinationTypeDTO(entity);
    }

    @Override
    public List<Destination_DestinationTypeDTO> findAll() {
        List<Destination_DestinationType> list = repository.findAll();
        return mapper.toDestination_DestinationTypeDTO(list);
    }

    @Override
    public Destination_DestinationTypeDTO findById(Long id) throws Exception{
        try {
            Destination_DestinationType entity = repository.findById(id).get();
            return mapper.toDestination_DestinationTypeDTO(entity);
        }catch (Exception e){
            throw new Exception("La entidad no fue encontrada");
        }
    }

    @Override
    public Destination_DestinationTypeDTO save(Destination_DestinationTypeDTO entity) throws Exception {
        Destination_DestinationType relation = mapper.toDestination_DestinationType(entity);
        if(repository.findById(entity.getId()).isEmpty()){
            return mapper.toDestination_DestinationTypeDTO(repository.save(relation));
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public Destination_DestinationTypeDTO update(Destination_DestinationTypeDTO entity) throws Exception {
        Destination_DestinationType relation = mapper.toDestination_DestinationType(entity);
        if(repository.findById(entity.getId()).isPresent()){
            return mapper.toDestination_DestinationTypeDTO(repository.save(relation));
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
    public void validate(Destination_DestinationTypeDTO entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }

}
