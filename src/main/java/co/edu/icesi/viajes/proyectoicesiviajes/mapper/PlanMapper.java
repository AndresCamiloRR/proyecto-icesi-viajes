package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Plan;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PlanMapper {

    List<Plan> toPlan(List<PlanDTO> planDTOList);
    List<PlanDTO> toPlanDTO(List<Plan> planList);

}
