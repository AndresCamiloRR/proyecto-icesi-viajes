package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Role_Permission;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.Role_PermissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface Role_PermissionMapper {

    @Mapping(source = "role.id", target = "role")
    @Mapping(source = "permission.id", target = "permission")
    Role_PermissionDTO toRole_PermissionDTO(Role_Permission entity);

    @Mapping(source = "role", target = "role.id")
    @Mapping(source = "permission", target = "permission.id")
    Role_Permission toRole_Permission(Role_PermissionDTO dto);

    @Mapping(source = "role.id", target = "role")
    @Mapping(source = "permission.id", target = "permission")
    List<Role_PermissionDTO> toRole_PermissionDTO(List<Role_Permission> entityList);

    @Mapping(source = "role", target = "role.id")
    @Mapping(source = "permission", target = "permission.id")
    List<Role_Permission> toRole_Permission(List<Role_PermissionDTO> dto);

}
