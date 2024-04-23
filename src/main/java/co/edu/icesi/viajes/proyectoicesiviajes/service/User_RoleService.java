package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.User_Role;

import java.util.List;

public interface User_RoleService extends GenericService<User_Role, Long> {

    List<User_Role> findByRole_Id(Long roleId);

    List<User_Role> findByUser_Id(Long userId);

    User_Role findByRole_IdAndUser_Id(Long role_id, Long user_id);

    void deleteByRole_Id(Long roleId);

    void deleteByUser_Id(Long userId);

}
