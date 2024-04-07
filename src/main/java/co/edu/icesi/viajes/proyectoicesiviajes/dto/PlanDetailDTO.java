package co.edu.icesi.viajes.proyectoicesiviajes.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class PlanDetailDTO {
    private Long id;
    private String food;
    private String lodging;
    private String transport;
    private String transfers;
    private Integer cost;
    private Date modifyate;
    private String status;
    private Long destinationId;
    private Integer numberOfNights;
    private Integer numberOfDays;
}
