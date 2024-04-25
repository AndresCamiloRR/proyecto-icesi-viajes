package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Role_Permission;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.Role_PermissionDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.Role_PermissionMapper;
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

    @Autowired
    Role_PermissionMapper mapper;

    @Override
    public List<Role_PermissionDTO> findAll() {
        List<Role_Permission> list = repository.findAll();
        return mapper.toRole_PermissionDTO(list);
    }

    @Override
    public Role_PermissionDTO findById(Long id) throws Exception{
        try {
            Role_Permission entity = repository.findById(id).get();
            return mapper.toRole_PermissionDTO(entity);
        }catch (Exception e){
            throw new Exception("La entidad no fue encontrada");
        }
    }

    @Override
    public Role_PermissionDTO save(Role_PermissionDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            Role_Permission role_permission = mapper.toRole_Permission(entity);
            return mapper.toRole_PermissionDTO(repository.save(role_permission));
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public Role_PermissionDTO update(Role_PermissionDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            Role_Permission role_permission = mapper.toRole_Permission(entity);
            return mapper.toRole_PermissionDTO(repository.save(role_permission));
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
    public void validate(Role_PermissionDTO entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public List<Role_PermissionDTO> findByRole_Id(Long roleId) {
        List<Role_Permission> list = repository.findByRole_Id(roleId);
        return mapper.toRole_PermissionDTO(list);
    }

    @Override
    public List<Role_PermissionDTO> findByPermission_Id(Long permissionId) {
        List<Role_Permission> list = repository.findByPermission_Id(permissionId);
        return mapper.toRole_PermissionDTO(list);
    }

    @Override
    public Role_PermissionDTO findByRole_IdAndPermission_Id(Long rol_id, Long permission_id) {
        Role_Permission list = repository.findByRole_IdAndPermission_Id(rol_id, permission_id);
        return mapper.toRole_PermissionDTO(list);
    }

    @Override
    public void deleteByRole_Id(Long roleId) {
        repository.deleteByRole_Id(roleId);
    }

    @Override
    public void deleteByPermission_Id(Long permissionId) {
        repository.deleteByPermission_Id(permissionId);
    }
}
