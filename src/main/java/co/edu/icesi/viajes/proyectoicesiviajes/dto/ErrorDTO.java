package co.edu.icesi.viajes.proyectoicesiviajes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ErrorDTO {

    private String message;
}