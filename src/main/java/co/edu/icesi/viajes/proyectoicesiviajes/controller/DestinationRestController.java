package co.edu.icesi.viajes.proyectoicesiviajes.controller;

import co.edu.icesi.viajes.proyectoicesiviajes.config.UserAuthenticationProvider;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.*;
import co.edu.icesi.viajes.proyectoicesiviajes.service.DestinationService;
import co.edu.icesi.viajes.proyectoicesiviajes.service.DestinationTypeService;
import co.edu.icesi.viajes.proyectoicesiviajes.service.Destination_DestinationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("api/v1/destinations")
public class DestinationRestController {

    @Autowired
    private DestinationService service;

    @Autowired
    private DestinationTypeService serviceType;

    @Autowired
    private Destination_DestinationTypeService serviceTypeRelation;

    @PostMapping(path = "/save")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'AGENT')")
    public String saveDestination(@RequestBody DestinationDTO userDTO){
        try{
            return service.save(userDTO).getName();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping(path = "/all")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VIEWER', 'AGENT')")
    public List<DestinationDTO> getAll() {
        System.out.println( service.findByStatus("Active"));
        return service.findByStatus("Active");
    }

    @GetMapping(path = "/types")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VIEWER', 'AGENT')")
    public List<DestinationTypeDTO> getTypes() {
        return serviceType.findAll();
    }

    @PostMapping(path = "/delete")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'AGENT')")
    public void deleteDestination(@RequestBody Long id) throws Exception {
        System.out.println("entro");
        System.out.println(id);
        service.deleteById(id);
    }

    @PostMapping(path = "/create")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'AGENT')")
    public DestinationDTO createDestination(@RequestBody DestinationDTO destination) throws Exception {
        System.out.println(destination);

        ArrayList<String> tagsList = destination.getSelectedTypes();

        DestinationDTO newDestination = service.save(destination);

        tagsList.forEach(typeName-> {

            DestinationTypeDTO type= serviceType.findByName(typeName);

            try {
                long randomPositiveLong = Math.abs(UUID.randomUUID().getLeastSignificantBits());
                serviceTypeRelation.save(new Destination_DestinationTypeDTO(randomPositiveLong,type.getId(),newDestination.getId()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("entro");
        return newDestination;
    }

    @PostMapping(path = "/update")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'AGENT')")
    public DestinationDTO updateDestination(@RequestBody DestinationDTO destination) throws Exception {
        System.out.println("UPDATE");
        return service.update(destination);
    }

    @PostMapping(path = "/getTypes")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'AGENT', 'VIEWER')")
    public List<DestinationTypeSimpleDTO> getTypes(@RequestBody Long id){
        return service.getTypes(id);
    }
}



