package co.edu.icesi.viajes.proyectoicesiviajes.dto;

import lombok.*;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class EventDTO {
    private Long id;
    private String entity;
    private String type;
    private String idEntity;
    private String idUser;
    private Date date;
}
