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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/clients")
public class ClientRestController {

    @Autowired
    private ClientService service;

    @GetMapping(path = "/all")
    public List<ClientDTO> getAll() {
        return service.findAll();
    }
}
