package co.edu.icesi.viajes.proyectoicesiviajes.controller;

import co.edu.icesi.viajes.proyectoicesiviajes.dto.ClientDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDetailDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDetail_PlanDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.Destination;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.DestinationChartTypeDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.*;
import co.edu.icesi.viajes.proyectoicesiviajes.service.PlanDetailService;
import co.edu.icesi.viajes.proyectoicesiviajes.service.PlanDetail_PlanService;
import co.edu.icesi.viajes.proyectoicesiviajes.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
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
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VIEWER', 'AGENT')")
    public List<PlanDTO> getAll() {
        return service.findByStatus("Active");
    }

    @PostMapping(path = "/create")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'AGENT')")
    public PlanDTO createPlan(@RequestBody PlanDTO plan) throws Exception {
        System.out.println(plan);
        return service.save(plan);
    }

    @PostMapping(path = "/createdatails")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'AGENT')")
    public PlanDetailDTO createDetails(@RequestBody PlanDetailDTO detail) throws Exception {
        System.out.println(detail);
        return serviceDetail.save(detail);
    }

    @PostMapping(path = "/createplandatails")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'AGENT')")
    public PlanDetail_PlanDTO createPlanDetails(@RequestBody PlanDetail_PlanDTO detail) throws Exception {
        System.out.println(detail);
        return servicePlanDetail.save(detail);
    }

    @PostMapping(path = "/deletePlan")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'AGENT')")
    public void deletePlan(@RequestBody Long id) throws Exception {
        

        service.deleteById(id);

    }

    @GetMapping(path = "/salesweek")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VIEWER', 'AGENT')")
    public Integer getSales() throws Exception {
        System.out.println("in");
        return service.findThisWeekDetails();
    }

    @GetMapping(path = "/clientsnum")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VIEWER', 'AGENT')")
    public Integer getClientsNum() throws Exception {
        System.out.println("in");
        return service.getClientsNum();
    }

    @GetMapping(path = "/money")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VIEWER', 'AGENT')")
    public Double getMoney() throws Exception {
        System.out.println("in");
        return service.getMoney();
    }

    @GetMapping(path = "/topTypes")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VIEWER', 'AGENT')")
    public List<DestinationChartTypeDTO> getTopTypes() throws Exception {
        System.out.println("in");
        return service.getTopTypes();
    }

    @GetMapping(path = "/topDestinations")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VIEWER', 'AGENT')")
    public List<DestinationTopDTO> getTopDestinations() throws Exception {
        System.out.println("in");
        return service.getTopDestinations();
    }


    @PostMapping(path = "/findDetail")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'VIEWER', 'AGENT')")
    public List<PlanDetailExtendedDTO> findDetail(@RequestBody Long id){
        System.out.println("in");
        return service.findAllPlanDetailsWithDestinationInfo(id);
    }


}
