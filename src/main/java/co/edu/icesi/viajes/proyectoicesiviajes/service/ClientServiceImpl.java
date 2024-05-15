package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Client;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.ClientDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.ClientMapper;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Scope("singleton")
@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository repository;

    @Autowired
    ClientMapper mapper;


    @Override
    public List<ClientDTO> findByNameContaining(String name) {
        List<Client> list = repository.findByNameContaining(name);
        return mapper.toClientDTO(list);
    }

    @Override
    public List<ClientDTO> findBySex(String sex) {
        List<Client> list = repository.findBySex(sex);
        return mapper.toClientDTO(list);
    }

    @Override
    public List<ClientDTO> findByStatus(String status) {
        List<Client> list = repository.findByStatus(status);
        return mapper.toClientDTO(list);
    }

    @Override
    public List<ClientDTO> findByTypeNID_Id(Long typeNID_id) {
        List<Client> list = repository.findByTypeNID_Id(typeNID_id);
        return mapper.toClientDTO(list);
    }

    @Override
    public List<ClientDTO> findByBirthDate(Date birthDate) {
        List<Client> list = repository.findByBirthDate(birthDate);
        return mapper.toClientDTO(list);
    }

    @Override
    public List<ClientDTO> findAll() {
        List<Client> list = repository.findAll();
        return mapper.toClientDTO(list);
    }

    @Override
    public ClientDTO findById(Long id) throws Exception{
        try{
            Client client = repository.findById(id).get();
            return mapper.toClientDTO(client);
        }catch (Exception e){
            throw new Exception("La entidad no fue encontrada");
        }
    }

    @Override
    public ClientDTO save(ClientDTO entity) throws Exception {
        Client client = mapper.toClient(entity);

        System.out.println(client);
        if(repository.findById(entity.getId()).isEmpty()){
            return mapper.toClientDTO(repository.save(client));
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public ClientDTO update(ClientDTO entity) throws Exception {
        Client client = mapper.toClient(entity);
        if(repository.findById(entity.getId()).isPresent()){
            return mapper.toClientDTO(repository.save(client));
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
    public void validate(ClientDTO entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }
}
