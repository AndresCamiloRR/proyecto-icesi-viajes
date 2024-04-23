package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Role_Permission;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.Role_PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class Role_PermissionServiceImpl implements Role_PermissionService{

    @Autowired
    Role_PermissionRepository repository;


    @Override
    public List<Role_Permission> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Role_Permission> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Role_Permission save(Role_Permission entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public Role_Permission update(Role_Permission entity) throws Exception {
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
    public void validate(Role_Permission entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public List<Role_Permission> findByRol_Id(Long roleId) {
        return repository.findByRol_Id(roleId);
    }

    @Override
    public List<Role_Permission> findByPermission_Id(Long permissionId) {
        return repository.findByPermission_Id(permissionId);
    }

    @Override
    public Role_Permission findByRol_IdAndPermission_Id(Long rol_id, Long permission_id) {
        return repository.findByRol_IdAndPermission_Id(rol_id, permission_id);
    }

    @Override
    public void deleteByRol_Id(Long roleId) {
        repository.deleteByRol_Id(roleId);
    }

    @Override
    public void deleteByPermission_Id(Long permissionId) {
        repository.deleteByPermission_Id(permissionId);
    }
}
