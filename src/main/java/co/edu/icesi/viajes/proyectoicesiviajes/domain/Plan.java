package co.edu.icesi.viajes.proyectoicesiviajes.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "plan")
@ToString
@Getter
@Setter
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_people")
    private Integer numberOfPeople;

    @Column(name = "status")
    private String status;

    @Column(name = "request_date")
    private Date requestDate;

    @Column(name = "trip_start_date")
    private Date tripStartDate;

    @Column(name = "trip_end_date")
    private Date tripEndDate;

    @Column(name = "total_cost")
    private Integer totalCost;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
