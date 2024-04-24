package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.PlanDetail;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PlanDetailMapper {

    @Mapping(source = "destination", target = "destination.id")
    List<PlanDetail> toPlanDetail(List<PlanDetailDTO> planDetailDTOList);

    @Mapping(source = "destination.id", target = "destination")
    List<PlanDetailDTO> toPlanDetailDTO(List<PlanDetail> planDetailList);

    @Mapping(source = "destination", target = "destination.id")
    PlanDetail toPlanDetail(PlanDetailDTO planDetailDTO);

    @Mapping(source = "destination.id", target = "destination")
    PlanDetailDTO toPlanDetailDTO(PlanDetail planDetail);

}
