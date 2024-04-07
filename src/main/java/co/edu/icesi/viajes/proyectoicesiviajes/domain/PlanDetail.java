package co.edu.icesi.viajes.proyectoicesiviajes.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "plan_detail")
@ToString
@Getter
@Setter
public class PlanDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "food")
    private String food;

    @Column(name = "lodging")
    private String lodging;

    @Column(name = "transport")
    private String transport;

    @Column(name = "transfers")
    private String transfers;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "modifyate")
    private Date modifyate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @Column(name = "number_of_nights")
    private Integer numberOfNights;

    @Column(name = "number_of_days")
    private Integer numberOfDays;
}
