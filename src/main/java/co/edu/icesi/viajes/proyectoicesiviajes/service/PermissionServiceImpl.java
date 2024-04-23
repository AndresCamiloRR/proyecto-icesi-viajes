package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Permission;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    PermissionRepository repository;

    @Override
    public List<Permission> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Permission> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Permission save(Permission entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public Permission update(Permission entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad no existe en el sistema");
        }
    }

    @Override
    public void validate(Permission entity) throws Exception {

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
    public List<Permission> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Permission> findByStatus(String status) {
        return repository.findByStatus(status);
    }
}
