package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.User;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User save(User entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public User update(User entity) throws Exception {
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
    public void validate(User entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public List<User> findByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public List<User> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<User> findByNationalID(String nationalID) {
        return repository.findByNationalID(nationalID);
    }

    @Override
    public List<User> findByName(String name) {
        return repository.findByName(name);
    }
}
