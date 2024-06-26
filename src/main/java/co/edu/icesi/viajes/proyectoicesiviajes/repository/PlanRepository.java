package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Plan;
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
}
