package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.User_Role;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.User_RoleDTO;

import java.util.List;

public interface User_RoleService extends GenericService<User_RoleDTO, Long> {

    List<User_RoleDTO> findByRole_Id(Long roleId);

    List<User_RoleDTO> findByUser_Id(Long userId);

    User_RoleDTO findByRole_IdAndUser_Id(Long role_id, Long user_id);

    void deleteByRole_Id(Long roleId);

    void deleteByUser_Id(Long userId);

}
