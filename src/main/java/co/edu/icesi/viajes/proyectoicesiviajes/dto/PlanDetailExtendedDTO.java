package co.edu.icesi.viajes.proyectoicesiviajes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class PlanDetailExtendedDTO {
    private String food;
    private String lodging;
    private String transport;
    private String transfers;
    private String destination;
    private Integer numberOfNights;
    private Integer numberOfDays;
}
