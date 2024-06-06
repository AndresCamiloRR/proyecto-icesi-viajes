package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Destination;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.Plan;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.DestinationChartTypeDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.*;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.DestinationMapper;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.PlanMapper;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Scope("singleton")
@Service
public class PlanServiceImpl implements PlanService{

    @Autowired
    PlanRepository repository;

    @Autowired
    PlanMapper mapper;

    @Autowired
    DestinationMapper desMapper;

    @Override
    public List<PlanDTO> findAll() {
        List<Plan> list = repository.findAll();
        return mapper.toPlanDTO(list);
    }

    @Override
    public PlanDTO findById(Long id) throws Exception{
        try {
            Plan entity = repository.findById(id).get();
            return mapper.toPlanDTO(entity);
        }catch (Exception e){
            throw new Exception("La entidad no fue encontrada");
        }
    }

    @Override
    public PlanDTO save(PlanDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            Plan plan = mapper.toPlan(entity);
            return mapper.toPlanDTO(repository.save(plan));
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public PlanDTO update(PlanDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            Plan plan = mapper.toPlan(entity);
            return mapper.toPlanDTO(repository.save(plan));
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
    public void validate(PlanDTO entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public List<PlanDTO> findByCode(String code) {
        List<Plan> list = repository.findByCode(code);
        return mapper.toPlanDTO(list);
    }

    @Override
    public List<PlanDTO> findByName(String name) {
        List<Plan> list = repository.findByName(name);
        return mapper.toPlanDTO(list);
    }

    @Override
    public List<PlanDTO> findByStatus(String status) {
        List<Plan> list = repository.findByStatus(status);
        return mapper.toPlanDTO(list);
    }

    @Override
    public List<PlanDTO> findByRequestDate(Date requestDate) {
        List<Plan> list = repository.findByRequestDate(requestDate);
        return mapper.toPlanDTO(list);
    }

    @Override
    public List<PlanDTO> findByTripStartDate(Date tripStartDate) {
        List<Plan> list = repository.findByTripStartDate(tripStartDate);
        return mapper.toPlanDTO(list);
    }

    @Override
    public List<PlanDTO> findByTripEndDate(Date tripEndDate) {
        List<Plan> list = repository.findByTripEndDate(tripEndDate);
        return mapper.toPlanDTO(list);
    }

    @Override
    public List<PlanDTO> findByTotalCost(Integer totalCost) {
        List<Plan> list = repository.findByTotalCost(totalCost);
        return mapper.toPlanDTO(list);
    }

    @Override
    public List<PlanDTO> findByNumberOfPeople(Integer numberOfPeople) {
        List<Plan> list = repository.findByNumberOfPeople(numberOfPeople);
        return mapper.toPlanDTO(list);
    }

    @Override
    public List<PlanDTO> findByClient_Id(Long clientId) {
        List<Plan> list = repository.findByClient_Id(clientId);
        return mapper.toPlanDTO(list);
    }

    @Override
    public List<PlanDTO> findByUser_Id(Long userId) {
        List<Plan> list = repository.findByUser_Id(userId);
        return mapper.toPlanDTO(list);
    }

    @Override
    public List<PlanDTO> findByTripStartDateBetween(Date startDate, Date endDate) {
        List<Plan> list = repository.findByTripStartDateBetween(startDate, endDate);
        return mapper.toPlanDTO(list);
    }

    @Override
    public List<PlanDTO> findByTripEndDateBetween(Date startDate, Date endDate) {
        List<Plan> list = repository.findByTripEndDateBetween(startDate, endDate);
        return mapper.toPlanDTO(list);
    }

    @Override
    public Integer findThisWeekDetails() {
        return repository.findThisWeekDetails();
    }

    @Override
    public Integer getClientsNum() {
        return repository.getClientsNum();
    }

    @Override
    public Double getMoney() {
        return repository.getMoney();
    }

    @Override
    public List<DestinationChartTypeDTO> getTopTypes(){
        return repository.getTopTypes();
    }

    @Override
    public List<DestinationTopDTO> getTopDestinations() {
        return repository.getTopDestinations();
    }

    @Override
    public List<PlanDetailExtendedDTO> findAllPlanDetailsWithDestinationInfo(Long id) { return repository.findAllPlanDetailsWithDestinationInfo(id); };
}
