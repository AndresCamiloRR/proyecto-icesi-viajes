package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Permission;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PermissionDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.PermissionMapper;
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

    @Autowired
    PermissionMapper mapper;

    @Override
    public List<PermissionDTO> findAll() {
        List<Permission> list = repository.findAll();
        return mapper.toPermissionDTO(list);
    }

    @Override
    public PermissionDTO findById(Long id) throws Exception{
        try {
            Permission entity = repository.findById(id).get();
            return mapper.toPermissionDTO(entity);
        }catch (Exception e){
            throw new Exception("La entidad no fue encontrada");
        }
    }

    @Override
    public PermissionDTO save(PermissionDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            Permission permission = mapper.toPermission(entity);
            return mapper.toPermissionDTO(repository.save(permission));
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public PermissionDTO update(PermissionDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            Permission permission = mapper.toPermission(entity);
            return mapper.toPermissionDTO(repository.save(permission));
        }else{
            throw new Exception("La entidad no existe en el sistema");
        }
    }

    @Override
    public void validate(PermissionDTO entity) throws Exception {

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
    public List<PermissionDTO> findByName(String name) {
        List<Permission> list = repository.findByName(name);
        return mapper.toPermissionDTO(list);
    }

    @Override
    public List<PermissionDTO> findByStatus(String status) {
        List<Permission> list = repository.findByStatus(status);
        return mapper.toPermissionDTO(list);
    }
}
