package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Plan;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.PlanDetail;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.PlanDetail_Plan;

import java.util.List;

public interface PlanDetail_PlanService extends GenericService<PlanDetail_Plan, Long>{

    List<PlanDetail_Plan> findByPlanDetail_Id(Long planDetailId);

    List<PlanDetail_Plan> findByPlan_Id(Long planId);

    PlanDetail_Plan findByPlanDetail_IdAndPlan_Id(Long planDetail_id, Long plan_id);

    void deleteByPlanDetail_Id(Long planDetailId);

    void deleteByPlan_Id(Long planId);

}
