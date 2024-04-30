package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Role;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.RoleDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    List<Role> toRole(List<RoleDTO> roleDTOList);
    List<RoleDTO> toRoleDTO(List<Role> roleList);

    Role toRole(RoleDTO roleDTOList);
    RoleDTO toRoleDTO(Role role);

}
