package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Plan;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDTO;

import java.util.Date;
import java.util.List;

public interface PlanService extends GenericService<PlanDTO, Long> {

    List<PlanDTO> findByCode(String code);

    List<PlanDTO> findByName(String name);

    List<PlanDTO> findByStatus(String status);

    List<PlanDTO> findByRequestDate(Date requestDate);

    List<PlanDTO> findByTripStartDate(Date tripStartDate);

    List<PlanDTO> findByTripEndDate(Date tripEndDate);

    List<PlanDTO> findByTotalCost(Integer totalCost);

    List<PlanDTO> findByNumberOfPeople(Integer numberOfPeople);

    List<PlanDTO> findByClient_Id(Long clientId);

    List<PlanDTO> findByUser_Id(Long userId);

    List<PlanDTO> findByTripStartDateBetween(Date startDate, Date endDate);

    List<PlanDTO> findByTripEndDateBetween(Date startDate, Date endDate);

}
