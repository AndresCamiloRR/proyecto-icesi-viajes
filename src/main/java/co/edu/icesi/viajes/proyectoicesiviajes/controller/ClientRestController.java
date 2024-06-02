package co.edu.icesi.viajes.proyectoicesiviajes.controller;

import co.edu.icesi.viajes.proyectoicesiviajes.config.UserAuthenticationProvider;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.ClientDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.CredentialsDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.UserDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.UserMapper;
import co.edu.icesi.viajes.proyectoicesiviajes.service.ClientService;
import co.edu.icesi.viajes.proyectoicesiviajes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("api/v1/clients")
public class ClientRestController {

    @Autowired
    private ClientService service;

    @GetMapping(path = "/all")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<ClientDTO> getAll() {
        return service.findByStatus("Active");
    }

    @PostMapping(path = "/get")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ClientDTO getClient(@RequestBody Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping(path = "/create")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ClientDTO createClient(@RequestBody ClientDTO client) throws Exception {
        System.out.println(client);
        System.out.println("entro");
        //long randomPositiveLong = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        //ClientDTO client = new ClientDTO(randomPositiveLong, id, firstName,lastName,firstName + " " + lastName, phone , sex, "Active", Long.parseLong(idType), dateOfBirth, null);
        return service.save(client);
    }

    @PostMapping(path = "/delete")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteClient(@RequestBody Long id) throws Exception {
        System.out.println("entro");
        System.out.println(id);
        service.deleteById(id);
    }

    @PostMapping(path = "/update")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ClientDTO updateClient(@RequestBody ClientDTO client) throws Exception {
        System.out.println(client);
        System.out.println("entro");
        //long randomPositiveLong = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        //ClientDTO client = new ClientDTO(randomPositiveLong, id, firstName,lastName,firstName + " " + lastName, phone , sex, "Active", Long.parseLong(idType), dateOfBirth, null);
        return service.update(client);
    }
}
