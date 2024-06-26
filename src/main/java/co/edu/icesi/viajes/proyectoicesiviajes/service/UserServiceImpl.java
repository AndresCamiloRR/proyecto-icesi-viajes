package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.User;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.UserDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.UserMapper;
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

    @Autowired
    UserMapper mapper;

    @Override
    public List<UserDTO> findAll() {
        List<User> list = repository.findAll();
        return mapper.toUserDTO(list);
    }

    @Override
    public UserDTO findById(Long id) throws Exception{
        try {
            User user = repository.findById(id).get();
            return mapper.toUserDTO(user);
        }catch (Exception e){
            throw new Exception("La entidad no fue encontrada");
        }
    }

    @Override
    public UserDTO save(UserDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            User user = mapper.toUser(entity);
            return mapper.toUserDTO(repository.save(user));
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public UserDTO update(UserDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            User user = mapper.toUser(entity);
            return mapper.toUserDTO(repository.save(user));
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
    public void validate(UserDTO entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public List<UserDTO> findByLogin(String login) {
        List<User> list = repository.findByLogin(login);
        return mapper.toUserDTO(list);
    }

    @Override
    public List<UserDTO> findByStatus(String status) {
        List<User> list = repository.findByStatus(status);
        return mapper.toUserDTO(list);
    }

    @Override
    public List<UserDTO> findByNationalID(String nationalID) {
        List<User> list = repository.findByNationalID(nationalID);
        return mapper.toUserDTO(list);
    }

    @Override
    public List<UserDTO> findByName(String name) {
        List<User> list = repository.findByName(name);
        return mapper.toUserDTO(list);
    }
}
