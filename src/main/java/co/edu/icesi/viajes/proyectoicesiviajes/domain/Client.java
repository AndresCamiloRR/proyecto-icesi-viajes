package co.edu.icesi.viajes.proyectoicesiviajes.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "client")
@ToString
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "national_id")
    private String nationalID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "name")
    private String name;

    @Column(name = "tel1")
    private String tel1;

    @Column(name = "sex")
    private String sex;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "type_nid")
    private National_ID_Type typeNID;

    @Column(name = "birth_date")
    private Date birthDate;
}
