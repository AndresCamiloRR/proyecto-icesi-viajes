package co.edu.icesi.viajes.proyectoicesiviajes.controller;

import co.edu.icesi.viajes.proyectoicesiviajes.dto.ClientDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDetailDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDetail_PlanDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.service.PlanDetailService;
import co.edu.icesi.viajes.proyectoicesiviajes.service.PlanDetail_PlanService;
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

    @Autowired
    private PlanDetailService serviceDetail;

    @Autowired
    private PlanDetail_PlanService servicePlanDetail;

    @GetMapping(path = "/all")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<PlanDTO> getAll() {
        return service.findByStatus("Active");
    }

    @PostMapping(path = "/create")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public PlanDTO createPlan(@RequestBody PlanDTO plan) throws Exception {
        System.out.println(plan);
        return service.save(plan);
    }

    @PostMapping(path = "/createdatails")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public PlanDetailDTO createDetails(@RequestBody PlanDetailDTO detail) throws Exception {
        System.out.println(detail);
        return serviceDetail.save(detail);
    }

    @PostMapping(path = "/createplandatails")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public PlanDetail_PlanDTO createPlanDetails(@RequestBody PlanDetail_PlanDTO detail) throws Exception {
        System.out.println(detail);
        return servicePlanDetail.save(detail);
    }
}
