package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Role;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository repository;

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Role save(Role entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public Role update(Role entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad no existe en el sistema");
        }
    }

    @Override
    public void validate(Role entity) throws Exception {

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
    public Long count() {
        return repository.count();
    }

    @Override
    public List<Role> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Role> findByStatus(String status) {
        return repository.findByStatus(status);
    }

}
