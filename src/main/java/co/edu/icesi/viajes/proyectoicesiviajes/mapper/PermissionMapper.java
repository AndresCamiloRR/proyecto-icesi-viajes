package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Permission;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PermissionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {

    List<Permission> toPermission(List<PermissionDTO> permissionDTOList);
    List<PermissionDTO> toPermissionDTO(List<Permission> permissionList);

    Permission toPermission(PermissionDTO permissionDTO);
    PermissionDTO toPermissionDTO(Permission permission);

}
