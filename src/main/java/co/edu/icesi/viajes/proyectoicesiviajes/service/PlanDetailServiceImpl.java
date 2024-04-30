package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.PlanDetail;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDetailDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.mapper.PlanDetailMapper;
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

    @Autowired
    PlanDetailMapper mapper;

    @Override
    public List<PlanDetailDTO> findAll() {
        List<PlanDetail> list = repository.findAll();
        return mapper.toPlanDetailDTO(list);
    }

    @Override
    public PlanDetailDTO findById(Long id) throws Exception{
        try {
            PlanDetail planDetail = repository.findById(id).get();
            return mapper.toPlanDetailDTO(planDetail);
        }catch (Exception e){
            throw new Exception("La entidad no fue encontrada");
        }
    }

    @Override
    public PlanDetailDTO save(PlanDetailDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isEmpty()){
            PlanDetail planDetail = mapper.toPlanDetail(entity);
            return mapper.toPlanDetailDTO(repository.save(planDetail));
        }else{
            throw new Exception("La entidad ya existe en el sistema");
        }
    }

    @Override
    public PlanDetailDTO update(PlanDetailDTO entity) throws Exception {
        if(repository.findById(entity.getId()).isPresent()){
            PlanDetail planDetail = mapper.toPlanDetail(entity);
            return mapper.toPlanDetailDTO(repository.save(planDetail));
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
    public void validate(PlanDetailDTO entity) throws Exception {

    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public List<PlanDetailDTO> findByFood(String food) {
        List<PlanDetail> list = repository.findByFood(food);
        return mapper.toPlanDetailDTO(list);
    }

    @Override
    public List<PlanDetailDTO> findByLodging(String lodging) {
        List<PlanDetail> list = repository.findByLodging(lodging);
        return mapper.toPlanDetailDTO(list);
    }

    @Override
    public List<PlanDetailDTO> findByTransport(String transport) {
        List<PlanDetail> list = repository.findByTransport(transport);
        return mapper.toPlanDetailDTO(list);
    }

    @Override
    public List<PlanDetailDTO> findByTransfers(String transfers) {
        List<PlanDetail> list = repository.findByTransfers(transfers);
        return mapper.toPlanDetailDTO(list);
    }

    @Override
    public List<PlanDetailDTO> findByCost(Integer cost) {
        List<PlanDetail> list = repository.findByCost(cost);
        return mapper.toPlanDetailDTO(list);
    }

    @Override
    public List<PlanDetailDTO> findByStatus(String status) {
        List<PlanDetail> list = repository.findByStatus(status);
        return mapper.toPlanDetailDTO(list);
    }

    @Override
    public List<PlanDetailDTO> findByDestination_Id(Long destinationId) {
        List<PlanDetail> list = repository.findByDestination_Id(destinationId);
        return mapper.toPlanDetailDTO(list);
    }

    @Override
    public List<PlanDetailDTO> findByNumberOfNights(Integer numberOfNights) {
        List<PlanDetail> list = repository.findByNumberOfNights(numberOfNights);
        return mapper.toPlanDetailDTO(list);
    }

    @Override
    public List<PlanDetailDTO> findByNumberOfDays(Integer numberOfDays) {
        List<PlanDetail> list = repository.findByNumberOfDays(numberOfDays);
        return mapper.toPlanDetailDTO(list);
    }
}
