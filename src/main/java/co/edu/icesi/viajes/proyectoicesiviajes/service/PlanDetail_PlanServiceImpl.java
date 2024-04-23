package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.PlanDetail_Plan;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.PlanDetail_PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class PlanDetail_PlanServiceImpl implements PlanDetail_PlanService{

    @Autowired
    PlanDetail_PlanRepository repository;


    @Override
    public List<PlanDetail_Plan> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PlanDetail_Plan> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public PlanDetail_Plan save(PlanDetail_Plan entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public PlanDetail_Plan update(PlanDetail_Plan entity) throws Exception {
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
    public void validate(PlanDetail_Plan entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public List<PlanDetail_Plan> findByPlanDetail_Id(Long planDetailId) {
        return repository.findByPlanDetail_Id(planDetailId);
    }

    @Override
    public List<PlanDetail_Plan> findByPlan_Id(Long planId) {
        return repository.findByPlan_Id(planId);
    }

    @Override
    public PlanDetail_Plan findByPlanDetail_IdAndPlan_Id(Long planDetail_id, Long plan_id) {
        return repository.findByPlanDetail_IdAndPlan_Id(planDetail_id, plan_id);
    }

    @Override
    public void deleteByPlanDetail_Id(Long planDetailId) {
        repository.deleteByPlanDetail_Id(planDetailId);
    }

    @Override
    public void deleteByPlan_Id(Long planId) {
        repository.deleteById(planId);
    }
}
