package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.DestinationChartTypeDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.*;
import org.springframework.data.jpa.repository.Query;

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

    @Query("select count(*) from Plan")
    Integer findThisWeekDetails();

    @Query("SELECT COUNT(DISTINCT p.client) FROM Plan p")
    Integer getClientsNum();

    @Query("SELECT SUM(p.totalCost) FROM Plan p")
    Double getMoney();

    List<DestinationChartTypeDTO> getTopTypes();

    List<DestinationTopDTO> getTopDestinations();

    List<PlanDetailExtendedDTO> findAllPlanDetailsWithDestinationInfo(Long id);

}
