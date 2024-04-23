package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Client;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository repository;


    @Override
    public List<Client> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }

    @Override
    public List<Client> findBySex(String sex) {
        return repository.findBySex(sex);
    }

    @Override
    public List<Client> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<Client> findByTypeNID_Id(Long typeNID_id) {
        return repository.findByTypeNID_Id(typeNID_id);
    }

    @Override
    public List<Client> findByBirthDate(Date birthDate) {
        return repository.findByBirthDate(birthDate);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Client save(Client entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public Client update(Client entity) throws Exception {
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
    public void validate(Client entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }
}
