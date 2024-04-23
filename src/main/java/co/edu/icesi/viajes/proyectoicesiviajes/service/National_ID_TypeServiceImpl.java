package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.National_ID_Type;
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
    @Override
    public List<National_ID_Type> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<National_ID_Type> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public National_ID_Type save(National_ID_Type entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public National_ID_Type update(National_ID_Type entity) throws Exception {
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
    public List<National_ID_Type> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<National_ID_Type> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<National_ID_Type> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public void validate(National_ID_Type entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }
}
