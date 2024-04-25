package co.edu.icesi.viajes.proyectoicesiviajes.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ClientDTO {
    private Long id;
    private String nationalID;
    private String firstName;
    private String lastName;
    private String name;
    private String tel1;
    private String sex;
    private String status;
    private Long typeNID;
    private Date birthDate;
    private byte[] image;
}
