package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.PlanDetail_Plan;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDetail_PlanDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.PlanDetail_PlanMapper;
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
    
    @Autowired
    PlanDetail_PlanMapper mapper;


    @Override
    public List<PlanDetail_PlanDTO> findAll() {
        List<PlanDetail_Plan> list = repository.findAll();
        return mapper.toPlanDetail_PlanDTO(list);
    }

    @Override
    public PlanDetail_PlanDTO findById(Long id) throws Exception{
        try {
            PlanDetail_Plan entity = repository.findById(id).get();
            return mapper.toPlanDetail_PlanDTO(entity);
        }catch (Exception e){
            throw new Exception("La entidad no fue encontrada");
        }
    }

    @Override
    public PlanDetail_PlanDTO save(PlanDetail_PlanDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            PlanDetail_Plan planDetail_plan = mapper.toPlanDetail_Plan(entity);
            return mapper.toPlanDetail_PlanDTO(repository.save(planDetail_plan));
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public PlanDetail_PlanDTO update(PlanDetail_PlanDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            PlanDetail_Plan planDetail_plan = mapper.toPlanDetail_Plan(entity);
            return mapper.toPlanDetail_PlanDTO(repository.save(planDetail_plan));
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
    public void validate(PlanDetail_PlanDTO entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public List<PlanDetail_PlanDTO> findByPlanDetail_Id(Long planDetailId) {
        List<PlanDetail_Plan> list = repository.findByPlanDetail_Id(planDetailId);
        return mapper.toPlanDetail_PlanDTO(list);
    }

    @Override
    public List<PlanDetail_PlanDTO> findByPlan_Id(Long planId) {
        List<PlanDetail_Plan> list = repository.findByPlan_Id(planId);
        return mapper.toPlanDetail_PlanDTO(list);
    }

    @Override
    public PlanDetail_PlanDTO findByPlanDetail_IdAndPlan_Id(Long planDetail_id, Long plan_id) {
        PlanDetail_Plan entity = repository.findByPlanDetail_IdAndPlan_Id(planDetail_id, plan_id);
        return mapper.toPlanDetail_PlanDTO(entity);
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
