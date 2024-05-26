package co.edu.icesi.viajes.proyectoicesiviajes.controller;

import co.edu.icesi.viajes.proyectoicesiviajes.dto.ClientDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/plans")
public class PlanRestController {

    @Autowired
    private PlanService service;

    @GetMapping(path = "/all")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<PlanDTO> getAll() {
        return service.findByStatus("Active");
    }

    @PostMapping(path = "/create")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public PlanDTO createClient(@RequestBody PlanDTO plan) throws Exception {
        System.out.println(plan);

        //long randomPositiveLong = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        return service.save(plan);
    }
}
