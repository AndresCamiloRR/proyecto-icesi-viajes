package co.edu.icesi.viajes.proyectoicesiviajes.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "plan_detail_plan")
@ToString
@Getter
@Setter
public class PlanDetail_Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_plan_detail")
    private PlanDetail planDetail;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Plan plan;
}
