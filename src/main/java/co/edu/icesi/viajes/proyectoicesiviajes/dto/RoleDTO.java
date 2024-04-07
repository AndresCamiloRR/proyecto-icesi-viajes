package co.edu.icesi.viajes.proyectoicesiviajes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class RoleDTO {
    private Long id;
    private String name;
    private String status;
}
