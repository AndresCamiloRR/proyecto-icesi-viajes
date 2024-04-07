package co.edu.icesi.viajes.proyectoicesiviajes.repository;

import lombok.AllArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
public class Record {
    private Long id;
    private Long idContent;
    private Long idUser;
    private Date date;

    // Constructor, getters y setters
}
