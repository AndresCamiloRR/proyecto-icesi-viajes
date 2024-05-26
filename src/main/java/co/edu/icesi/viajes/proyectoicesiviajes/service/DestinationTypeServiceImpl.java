package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.DestinationType;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationTypeDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.DestinationTypeMapper;
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

    @Autowired
    DestinationTypeMapper mapper;

    @Override
    public List<DestinationTypeDTO> findByCode(String code) {
        List<DestinationType> list = repository.findByCode(code);
        return mapper.toDestinationTypeDTO(list);
    }

    @Override
    public DestinationTypeDTO findByName(String name) {
        List<DestinationType> list = repository.findByName(name);
        return mapper.toDestinationTypeDTO(list.get(0));
    }

    @Override
    public List<DestinationTypeDTO> findByStatus(String status) {
        List<DestinationType> list = repository.findByStatus(status);
        return mapper.toDestinationTypeDTO(list);
    }

    @Override
    public List<DestinationTypeDTO> findAll() {
        List<DestinationType> list = repository.findAll();
        return mapper.toDestinationTypeDTO(list);
    }

    @Override
    public DestinationTypeDTO findById(Long id) throws Exception{
        try {
            DestinationType entity = repository.findById(id).get();
            return mapper.toDestinationTypeDTO(entity);
        }catch (Exception e){
            throw new Exception("La entidad no fue encontrada");
        }
    }

    @Override
    public DestinationTypeDTO save(DestinationTypeDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            DestinationType destinationType = mapper.toDestinationType(entity);
            return mapper.toDestinationTypeDTO(repository.save(destinationType));
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public DestinationTypeDTO update(DestinationTypeDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            DestinationType destinationType = mapper.toDestinationType(entity);
            return mapper.toDestinationTypeDTO(repository.save(destinationType));
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
    public void validate(DestinationTypeDTO entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }
}
