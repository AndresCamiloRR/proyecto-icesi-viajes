package co.edu.icesi.viajes.proyectoicesiviajes.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "destination_destination_type")
@ToString
@Getter
@Setter
public class Destination_DestinationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_destination_type")
    private DestinationType destinationType;

    @ManyToOne
    @JoinColumn(name = "id_destination")
    private Destination destination;
}
