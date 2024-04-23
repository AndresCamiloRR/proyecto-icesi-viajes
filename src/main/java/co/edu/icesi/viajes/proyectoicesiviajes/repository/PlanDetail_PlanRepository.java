package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.PlanDetail_Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanDetail_PlanRepository extends JpaRepository<PlanDetail_Plan, Long> {

    List<PlanDetail_Plan> findByPlanDetail_Id(Long planDetailId);

    List<PlanDetail_Plan> findByPlan_Id(Long planId);

    PlanDetail_Plan findByPlanDetail_IdAndPlan_Id(Long planDetail_id, Long plan_id);

    void deleteByPlanDetail_Id(Long planDetailId);

    void deleteByPlan_Id(Long planId);

    void deleteById(Long id);

}
