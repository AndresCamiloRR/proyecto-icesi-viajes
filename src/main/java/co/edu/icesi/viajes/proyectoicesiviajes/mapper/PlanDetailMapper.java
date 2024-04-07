package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.PlanDetail;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDetailDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PlanDetailMapper {

    List<PlanDetail> toPlanDetail(List<PlanDetailDTO> planDetailDTOList);
    List<PlanDetailDTO> toPlanDetailDTO(List<PlanDetail> planDetailList);

}
