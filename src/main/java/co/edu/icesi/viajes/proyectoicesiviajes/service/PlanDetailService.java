package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.PlanDetail;

import java.util.Date;
import java.util.List;

public interface PlanDetailService extends GenericService<PlanDetail, Long> {

    List<PlanDetail> findByFood(String food);

    List<PlanDetail> findByLodging(String lodging);

    List<PlanDetail> findByTransport(String transport);

    List<PlanDetail> findByTransfers(String transfers);

    List<PlanDetail> findByCost(Integer cost);

    List<PlanDetail> findByStatus(String status);

    List<PlanDetail> findByDestination_Id(Long destinationId);

    List<PlanDetail> findByNumberOfNights(Integer numberOfNights);

    List<PlanDetail> findByNumberOfDays(Integer numberOfDays);

}
