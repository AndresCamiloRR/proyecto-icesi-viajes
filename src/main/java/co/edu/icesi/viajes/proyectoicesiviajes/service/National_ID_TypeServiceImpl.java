package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.National_ID_Type;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.National_ID_TypeDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.National_ID_TypeMapper;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.National_ID_TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class National_ID_TypeServiceImpl implements National_ID_TypeService{

    @Autowired
    private National_ID_TypeRepository repository;

    @Autowired
    private National_ID_TypeMapper mapper;

    @Override
    public List<National_ID_TypeDTO> findAll() {
        List<National_ID_Type> list = repository.findAll();
        return mapper.toNational_ID_TypeDTO(list);
    }

    @Override
    public National_ID_TypeDTO findById(Long id) throws Exception {
        try {
            National_ID_Type entity = repository.findById(id).get();
            return mapper.toNational_ID_TypeDTO(entity);
        }catch (Exception e){
            throw new Exception("La entidad no fue encontrada");
        }
    }

    @Override
    public National_ID_TypeDTO save(National_ID_TypeDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            National_ID_Type nationalIdType = mapper.toNational_ID_Type(entity);
            return mapper.toNational_ID_TypeDTO(repository.save(nationalIdType));
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public National_ID_TypeDTO update(National_ID_TypeDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            National_ID_Type nationalIdType = mapper.toNational_ID_Type(entity);
            return mapper.toNational_ID_TypeDTO(repository.save(nationalIdType));
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
    public List<National_ID_TypeDTO> findByCode(String code) {
        List<National_ID_Type> list = repository.findByCode(code);
        return mapper.toNational_ID_TypeDTO(list);
    }

    @Override
    public List<National_ID_TypeDTO> findByName(String name) {
        List<National_ID_Type> list = repository.findByName(name);
        return mapper.toNational_ID_TypeDTO(list);
    }

    @Override
    public List<National_ID_TypeDTO> findByStatus(String status) {
        List<National_ID_Type> list = repository.findByStatus(status);
        return mapper.toNational_ID_TypeDTO(list);
    }

    @Override
    public void validate(National_ID_TypeDTO entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }
}
