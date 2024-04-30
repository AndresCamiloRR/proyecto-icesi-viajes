package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Plan;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PlanMapper {

    @Mapping(source = "client", target = "client.id")
    @Mapping(source = "user", target = "user.id")
    List<Plan> toPlan(List<PlanDTO> planDTOList);

    @Mapping(source = "client.id", target = "client")
    @Mapping(source = "user.id", target = "user")
    List<PlanDTO> toPlanDTO(List<Plan> planList);

    @Mapping(source = "client", target = "client.id")
    @Mapping(source = "user", target = "user.id")
    Plan toPlan(PlanDTO planDTO);

    @Mapping(source = "client.id", target = "client")
    @Mapping(source = "user.id", target = "user")
    PlanDTO toPlanDTO(Plan plan);

}
