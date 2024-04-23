package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.PlanDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanDetailRepository extends JpaRepository<PlanDetail, Long> {

    List<PlanDetail> findByFood(String food);

    List<PlanDetail> findByLodging(String lodging);

    List<PlanDetail> findByTransport(String transport);

    List<PlanDetail> findByTransfers(String transfers);

    List<PlanDetail> findByCost(Integer cost);

    List<PlanDetail> findByStatus(String status);

    List<PlanDetail> findByDestination_Id(Long destinationId);

    List<PlanDetail> findByNumberOfNights(Integer numberOfNights);

    List<PlanDetail> findByNumberOfDays(Integer numberOfDays);

    @Modifying
    @Query("UPDATE PlanDetail p SET p.status = 'inactive' WHERE p.id = ?1")
    void deleteById(Long id);

}
