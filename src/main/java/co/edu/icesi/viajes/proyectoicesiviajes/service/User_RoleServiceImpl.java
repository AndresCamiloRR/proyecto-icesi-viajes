package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.User_Role;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.User_RoleDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.User_RoleMapper;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.User_RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class User_RoleServiceImpl implements User_RoleService{

    @Autowired
    User_RoleRepository repository;

    @Autowired
    User_RoleMapper mapper;

    @Override
    public List<User_RoleDTO> findAll() {
        List<User_Role> list = repository.findAll();
        return mapper.toUser_RoleDTO(list);
    }

    @Override
    public User_RoleDTO findById(Long id) throws Exception{
        try {
            User_Role role = repository.findById(id).get();
            return mapper.toUser_RoleDTO(role);
        }catch (Exception e){
            throw new Exception("La entidad no fue encontrada");
        }
    }

    @Override
    public User_RoleDTO save(User_RoleDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            User_Role user_role = mapper.toUser_Role(entity);
            return mapper.toUser_RoleDTO(repository.save(user_role));
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public User_RoleDTO update(User_RoleDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            User_Role user_role = mapper.toUser_Role(entity);
            return mapper.toUser_RoleDTO(repository.save(user_role));
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
    public void validate(User_RoleDTO entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public List<User_RoleDTO> findByRole_Id(Long roleId) {
        List<User_Role> list = repository.findByRole_Id(roleId);
        return mapper.toUser_RoleDTO(list);
    }

    @Override
    public List<User_RoleDTO> findByUser_Id(Long userId) {
        List<User_Role> list = repository.findByUser_Id(userId);
        return mapper.toUser_RoleDTO(list);
    }

    @Override
    public User_RoleDTO findByRole_IdAndUser_Id(Long role_id, Long user_id) {
        User_Role entity = repository.findByRole_IdAndUser_Id(role_id, user_id);
        return mapper.toUser_RoleDTO(entity);
    }

    @Override
    public void deleteByRole_Id(Long roleId) {
        repository.deleteByRole_Id(roleId);
    }

    @Override
    public void deleteByUser_Id(Long userId) {
        repository.deleteByUser_Id(userId);
    }
}
