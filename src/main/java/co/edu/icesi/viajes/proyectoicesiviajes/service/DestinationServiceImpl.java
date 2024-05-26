package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Destination;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.DestinationMapper;
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
    
    @Autowired
    DestinationMapper mapper;

    @Override
    public List<DestinationDTO> findByCode(String code) {
        List<Destination> list = repository.findByCode(code);
        return mapper.toDestinationDTO(list);
    }

    @Override
    public List<DestinationDTO> findByName(String name) {
        List<Destination> list = repository.findByName(name);
        return mapper.toDestinationDTO(list);
    }

    @Override
    public List<DestinationDTO> findByByLand(String byLand) {
        List<Destination> list = repository.findByByLand(byLand);
        return mapper.toDestinationDTO(list);
    }

    @Override
    public List<DestinationDTO> findByBySea(String bySea) {
        List<Destination> list = repository.findByBySea(bySea);
        return mapper.toDestinationDTO(list);
    }

    @Override
    public List<DestinationDTO> findByByAir(String byAir) {
        List<Destination> list = repository.findByByAir(byAir);
        return mapper.toDestinationDTO(list);
    }

    @Override
    public List<DestinationDTO> findByStatus(String status) {
        List<Destination> list = repository.findByStatus(status);
        return mapper.toDestinationDTO(list);
    }

    @Override
    public List<DestinationDTO> findAll() {
        List<Destination> list = repository.findAll();
        return mapper.toDestinationDTO(list);
    }

    @Override
    public DestinationDTO findById(Long id) throws Exception{
        try {
            Destination entity = repository.findById(id).get();
            return mapper.toDestinationDTO(entity);
        }catch (Exception e){
            throw new Exception("La entidad no fue encontrada");
        }
    }

    @Override
    public DestinationDTO save(DestinationDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            Destination destination = mapper.toDestination(entity);
            return mapper.toDestinationDTO(repository.save(destination));
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public DestinationDTO update(DestinationDTO entity) throws Exception {

        if(repository.findById(entity.getId()).isPresent()){
            Destination destination = mapper.toDestination(entity);
            return mapper.toDestinationDTO(repository.save(destination));
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
    public void validate(DestinationDTO entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }
}
