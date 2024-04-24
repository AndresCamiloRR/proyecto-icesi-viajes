package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Role;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.RoleDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.RoleMapper;
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

    @Autowired
    RoleMapper mapper;

    @Override
    public List<RoleDTO> findAll() {
        List<Role> list = repository.findAll();
        return mapper.toRoleDTO(list);
    }

    @Override
    public RoleDTO findById(Long id) throws Exception{
        try {
            Role entity = repository.findById(id).get();
            return mapper.toRoleDTO(entity);
        }catch (Exception e){
            throw new Exception("La entidad no fue encontrada");
        }
    }

    @Override
    public RoleDTO save(RoleDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            Role role = mapper.toRole(entity);
            return mapper.toRoleDTO(repository.save(role));
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public RoleDTO update(RoleDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            Role role = mapper.toRole(entity);
            return mapper.toRoleDTO(repository.save(role));
        }else{
            throw new Exception("La entidad no existe en el sistema");
        }
    }

    @Override
    public void validate(RoleDTO entity) throws Exception {

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
    public List<RoleDTO> findByName(String name) {
        List<Role> list = repository.findByName(name);
        return mapper.toRoleDTO(list);
    }

    @Override
    public List<RoleDTO> findByStatus(String status) {
        List<Role> list = repository.findByStatus(status);
        return mapper.toRoleDTO(list);
    }

}
