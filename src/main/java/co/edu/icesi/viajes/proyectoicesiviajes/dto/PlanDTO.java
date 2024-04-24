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
public class PlanDTO {
    private Long id;
    private String code;
    private String description;
    private String name;
    private Integer numberOfPeople;
    private String status;
    private Date requestDate;
    private Date tripStartDate;
    private Date tripEndDate;
    private Integer totalCost;
    private Long client;
    private Long user;
}
