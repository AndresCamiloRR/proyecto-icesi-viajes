package co.edu.icesi.viajes.proyectoicesiviajes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class DestinationTypeDTO {
    private Long id;
    private String code;
    private String name;
    private String description;
    private String status;
}
