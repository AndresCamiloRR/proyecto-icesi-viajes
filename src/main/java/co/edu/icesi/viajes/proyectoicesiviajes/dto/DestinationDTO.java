package co.edu.icesi.viajes.proyectoicesiviajes.dto;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class DestinationDTO {
    private Long id;
    private String code;
    private String name;
    private String description;
    private Double price;
    private String byLand;
    private String bySea;
    private String byAir;
    private String status;
    private String image;
    private ArrayList<String> selectedTypes ;
}
