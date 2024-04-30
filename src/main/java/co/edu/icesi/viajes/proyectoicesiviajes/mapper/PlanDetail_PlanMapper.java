package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.PlanDetail_Plan;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDetail_PlanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PlanDetail_PlanMapper {

    @Mapping(source = "planDetail.id", target = "planDetail")
    @Mapping(source = "plan.id", target = "plan")
    PlanDetail_PlanDTO toPlanDetail_PlanDTO(PlanDetail_Plan entity);

    @Mapping(source = "planDetail", target = "planDetail.id")
    @Mapping(source = "plan", target = "plan.id")
    PlanDetail_Plan toPlanDetail_Plan(PlanDetail_PlanDTO dto);

    @Mapping(source = "planDetail.id", target = "planDetail")
    @Mapping(source = "plan.id", target = "plan")
    List<PlanDetail_PlanDTO> toPlanDetail_PlanDTO(List<PlanDetail_Plan> entityList);

    @Mapping(source = "planDetail", target = "planDetail.id")
    @Mapping(source = "plan", target = "plan.id")
    List<PlanDetail_Plan> toPlanDetail_Plan(List<PlanDetail_PlanDTO> dto);

}
