package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.PlanDetail;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDetailDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PlanDetailService extends GenericService<PlanDetailDTO, Long> {

    List<PlanDetailDTO> findByFood(String food);

    List<PlanDetailDTO> findByLodging(String lodging);

    List<PlanDetailDTO> findByTransport(String transport);

    List<PlanDetailDTO> findByTransfers(String transfers);

    List<PlanDetailDTO> findByCost(Integer cost);

    List<PlanDetailDTO> findByStatus(String status);

    List<PlanDetailDTO> findByDestination_Id(Long destinationId);

    List<PlanDetailDTO> findByNumberOfNights(Integer numberOfNights);

    List<PlanDetailDTO> findByNumberOfDays(Integer numberOfDays);
}
