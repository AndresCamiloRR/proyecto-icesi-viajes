package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Plan;

import java.util.Date;
import java.util.List;

public interface PlanService extends GenericService<Plan, Long> {

    List<Plan> findByCode(String code);

    List<Plan> findByName(String name);

    List<Plan> findByStatus(String status);

    List<Plan> findByRequestDate(Date requestDate);

    List<Plan> findByTripStartDate(Date tripStartDate);

    List<Plan> findByTripEndDate(Date tripEndDate);

    List<Plan> findByTotalCost(Integer totalCost);

    List<Plan> findByNumberOfPeople(Integer numberOfPeople);

    List<Plan> findByClient_Id(Long clientId);

    List<Plan> findByUser_Id(Long userId);

    List<Plan> findByTripStartDateBetween(Date startDate, Date endDate);

    List<Plan> findByTripEndDateBetween(Date startDate, Date endDate);

}
