package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Plan;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class PlanServiceImpl implements PlanService{

    @Autowired
    PlanRepository repository;

    @Override
    public List<Plan> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Plan> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Plan save(Plan entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public Plan update(Plan entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            return repository.save(entity);
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
    public void validate(Plan entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public List<Plan> findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public List<Plan> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Plan> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<Plan> findByRequestDate(Date requestDate) {
        return repository.findByRequestDate(requestDate);
    }

    @Override
    public List<Plan> findByTripStartDate(Date tripStartDate) {
        return repository.findByTripStartDate(tripStartDate);
    }

    @Override
    public List<Plan> findByTripEndDate(Date tripEndDate) {
        return repository.findByTripEndDate(tripEndDate);
    }

    @Override
    public List<Plan> findByTotalCost(Integer totalCost) {
        return repository.findByTotalCost(totalCost);
    }

    @Override
    public List<Plan> findByNumberOfPeople(Integer numberOfPeople) {
        return repository.findByNumberOfPeople(numberOfPeople);
    }

    @Override
    public List<Plan> findByClient_Id(Long clientId) {
        return repository.findByClient_Id(clientId);
    }

    @Override
    public List<Plan> findByUser_Id(Long userId) {
        return repository.findByUser_Id(userId);
    }

    @Override
    public List<Plan> findByTripStartDateBetween(Date startDate, Date endDate) {
        return repository.findByTripStartDateBetween(startDate, endDate);
    }

    @Override
    public List<Plan> findByTripEndDateBetween(Date startDate, Date endDate) {
        return repository.findByTripEndDateBetween(startDate, endDate);
    }
}
