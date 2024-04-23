package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.PlanDetail;
import co.edu.icesi.viajes.proyectoicesiviajes.repository.PlanDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class PlanDetailServiceImpl implements PlanDetailService{

    @Autowired
    PlanDetailRepository repository;


    @Override
    public List<PlanDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PlanDetail> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public PlanDetail save(PlanDetail entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public PlanDetail update(PlanDetail entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            return repository.save(entity);
        }else{
            throw new Exception("La entidad no existe en el sistema");
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }else{
            throw new Exception("La entidad no existe en el sistema");
        }
    }

    @Override
    public void validate(PlanDetail entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public List<PlanDetail> findByFood(String food) {
        return repository.findByFood(food);
    }

    @Override
    public List<PlanDetail> findByLodging(String lodging) {
        return repository.findByLodging(lodging);
    }

    @Override
    public List<PlanDetail> findByTransport(String transport) {
        return repository.findByTransport(transport);
    }

    @Override
    public List<PlanDetail> findByTransfers(String transfers) {
        return repository.findByTransfers(transfers);
    }

    @Override
    public List<PlanDetail> findByCost(Integer cost) {
        return repository.findByCost(cost);
    }

    @Override
    public List<PlanDetail> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<PlanDetail> findByDestination_Id(Long destinationId) {
        return repository.findByDestination_Id(destinationId);
    }

    @Override
    public List<PlanDetail> findByNumberOfNights(Integer numberOfNights) {
        return repository.findByNumberOfNights(numberOfNights);
    }

    @Override
    public List<PlanDetail> findByNumberOfDays(Integer numberOfDays) {
        return repository.findByNumberOfDays(numberOfDays);
    }
}
