package co.edu.icesi.viajes.proyectoicesiviajes.service;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.User;

import java.util.List;

public interface UserService extends GenericService<User, Long> {

    List<User> findByLogin(String login);

    List<User> findByStatus(String status);

    List<User> findByNationalID(String nationalID);

    List<User> findByName(String name);

}
