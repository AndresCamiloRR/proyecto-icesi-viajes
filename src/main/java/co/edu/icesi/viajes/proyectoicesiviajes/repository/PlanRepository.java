package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Destination;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.Plan;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.DestinationChartTypeDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationTopDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDetailDestinationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

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

    @Modifying
    @Query("UPDATE Plan p SET p.status = 'inactive' WHERE p.id = ?1")
    void deleteById(Long id);

    @Query("select count(*) from Plan")
    Integer findThisWeekDetails();

    @Query("SELECT COUNT(DISTINCT p.client) FROM Plan p")
    Integer getClientsNum();

    @Query("SELECT SUM(p.totalCost) FROM Plan p")
    Double getMoney();
    @Query(nativeQuery = true)
    List<DestinationChartTypeDTO> getTopTypes();

    @Query(nativeQuery = true)
    List<DestinationTopDTO> getTopDestinations();

    @Query("SELECT pd.id, p.code, p.description, p.name, p.numberOfPeople, p.status, " +
            "p.requestDate, p.tripStartDate, p.tripEndDate, p.totalCost, p.client.id, p.user.id, " +
            "string_agg(d.code, ',') AS destinationCodes, string_agg(d.name, ',') AS destinationNames " +
            "FROM PlanDetail_Plan pdp " +
            "JOIN pdp.plan p " +
            "JOIN pdp.planDetail pd " +
            "JOIN pd.destination d " +
            "WHERE p.status = 'Active' " +
            "GROUP BY pd.id, p.code, p.description, p.name, p.numberOfPeople, p.status, " +
            "p.requestDate, p.tripStartDate, p.tripEndDate, p.totalCost, p.client.id, p.user.id")
    List<Object[]> findAllPlanDetailsWithDestinationInfo();



}
