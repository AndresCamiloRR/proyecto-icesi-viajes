package co.edu.icesi.viajes.proyectoicesiviajes.mapper;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.User_Role;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.User_RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface User_RoleMapper {

    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "role.id", target = "role")
    User_RoleDTO toUser_RoleDTO(User_Role entity);

    @Mapping(source = "user", target = "user.id")
    @Mapping(source = "role", target = "role.id")
    User_Role toUser_Role(User_RoleDTO dto);

    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "role.id", target = "role")
    List<User_RoleDTO> toUser_RoleDTO(List<User_Role> entityList);

    @Mapping(source = "user", target = "user.id")
    @Mapping(source = "role", target = "role.id")
    List<User_Role> toUser_Role(List<User_RoleDTO> dtoList);

}
