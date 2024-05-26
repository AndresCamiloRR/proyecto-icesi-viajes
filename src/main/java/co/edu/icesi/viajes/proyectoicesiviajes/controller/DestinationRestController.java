package co.edu.icesi.viajes.proyectoicesiviajes.controller;

import co.edu.icesi.viajes.proyectoicesiviajes.config.UserAuthenticationProvider;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.CredentialsDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationTypeDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.UserDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.service.DestinationService;
import co.edu.icesi.viajes.proyectoicesiviajes.service.DestinationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/destinations")
public class DestinationRestController {

    @Autowired
    private DestinationService service;

    @Autowired
    private DestinationTypeService serviceType;

    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping(path = "/save")
    public String saveDestination(@RequestBody DestinationDTO userDTO){
        try{
            return service.save(userDTO).getName();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping(path = "/all")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<DestinationDTO> getAll() {
        System.out.println( service.findByStatus("Active"));
        return service.findByStatus("Active");
    }

    @GetMapping(path = "/types")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<DestinationTypeDTO> getTypes() {
        return serviceType.findAll();
    }

    @PostMapping(path = "/delete")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteDestination(@RequestBody Long id) throws Exception {
        System.out.println("entro");
        System.out.println(id);
        service.deleteById(id);
    }

    @PostMapping(path = "/create")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public DestinationDTO createDestination(@RequestBody DestinationDTO user) throws Exception {
        System.out.println(user);
        System.out.println("entro");
        return service.save(user);
    }

    @PostMapping(path = "/update")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public DestinationDTO updateDestination(@RequestBody DestinationDTO user) throws Exception {
        System.out.println("UPDATE");
        return service.update(user);
    }
}



