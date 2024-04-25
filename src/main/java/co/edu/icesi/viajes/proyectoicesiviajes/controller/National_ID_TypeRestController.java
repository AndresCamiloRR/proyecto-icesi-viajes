package co.edu.icesi.viajes.proyectoicesiviajes.controller;

import co.edu.icesi.viajes.proyectoicesiviajes.dto.National_ID_TypeDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.service.National_ID_TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/idTypes")
public class National_ID_TypeRestController {

    @Autowired
    private National_ID_TypeService service;

    @GetMapping(path = "/all")
    public List<National_ID_TypeDTO> getAll(){
        return service.findAll();
    }

}
