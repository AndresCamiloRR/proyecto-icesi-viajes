package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.User;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.UserDTO;

import java.util.List;

public interface UserService extends GenericService<UserDTO, Long> {

    List<UserDTO> findByLogin(String login);

    List<UserDTO> findByStatus(String status);

    List<UserDTO> findByNationalID(String nationalID);

    List<UserDTO> findByName(String name);

}
