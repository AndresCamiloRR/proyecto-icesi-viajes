package co.edu.icesi.viajes.proyectoicesiviajes.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class PlanDetailDestinationDTO {
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
    private List<String> destinationCodes;
    private List<String> destinationNames;

    // Constructor sin argumentos
    public PlanDetailDestinationDTO() {}
}
