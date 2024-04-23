package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import co.edu.icesi.viajes.proyectoicesiviajes.domain.Event;
import co.edu.icesi.viajes.proyectoicesiviajes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByEntity(String entity);

    List<Event> findByType(String type);

    List<Event> findByIdUser(User idUser);

    List<Event> findByIdEntity(String idEntity);

    List<Event> findByDate(Date date);

}
