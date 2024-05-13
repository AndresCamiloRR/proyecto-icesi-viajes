package co.edu.icesi.viajes.proyectoicesiviajes.domain;

import co.edu.icesi.viajes.proyectoicesiviajes.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@ToString
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "national_id")
    private String nationalID;

    @Column(name = "status")
    private String status;

    @Column(name = "image")
    private byte[] image;

    @Enumerated (EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
