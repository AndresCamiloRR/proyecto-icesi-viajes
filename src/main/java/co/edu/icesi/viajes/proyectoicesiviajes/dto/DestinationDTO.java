package co.edu.icesi.viajes.proyectoicesiviajes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class DestinationDTO {
    private Long id;
    private String code;
    private String name;
    private String description;
    private String byLand;
    private String bySea;
    private String byAir;
    private String status;
}
