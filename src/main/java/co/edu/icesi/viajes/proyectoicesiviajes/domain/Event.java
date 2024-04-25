package co.edu.icesi.viajes.proyectoicesiviajes.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Entity
@Table(name = "event")
@ToString
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String entity;

    @Column(name = "type")
    private String type;

    @Column(name = "id_name")
    private String idEntity;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User idUser;

    @Column(name = "date")
    private Date date;
}
