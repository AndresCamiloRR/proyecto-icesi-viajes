package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.User_Role;
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


    @Override
    public List<User_Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User_Role> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User_Role save(User_Role entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public User_Role update(User_Role entity) throws Exception {
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
    public void validate(User_Role entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public List<User_Role> findByRole_Id(Long roleId) {
        return repository.findByRole_Id(roleId);
    }

    @Override
    public List<User_Role> findByUser_Id(Long userId) {
        return repository.findByUser_Id(userId);
    }

    @Override
    public User_Role findByRole_IdAndUser_Id(Long role_id, Long user_id) {
        return repository.findByRole_IdAndUser_Id(role_id, user_id);
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
