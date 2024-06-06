package co.edu.icesi.viajes.proyectoicesiviajes.domain;

import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationTopDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.PlanDetailDestinationDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@NamedNativeQuery(name = "Plan.getTopTypes",
        query = "SELECT dt.name as name, COUNT(*) AS number FROM plan_detail pd JOIN destination_destination_Type ddt ON pd.destination_id = ddt.id_destination JOIN destination_Type dt ON ddt.id_destination_type = dt.id GROUP BY dt.name",
        resultSetMapping = "Mapping.DestinationChartTypeDTO")
@NamedNativeQuery(name = "Plan.getTopDestinations",
        query = "SELECT d.name as name, d.description as description, d.image as image FROM (SELECT destination_id, COUNT(*) as count FROM plan_detail GROUP BY destination_id ORDER BY count DESC LIMIT 3) AS top_destinations JOIN destination d ON top_destinations.destination_id = d.id",
        resultSetMapping = "Mapping.DestinationTopDTO")
@NamedNativeQuery(name = "Plan.findAllPlanDetailsWithDestinationInfo",
        query = "SELECT pd.id as id, p.code as code, p.description as description, " +
                "p.name as name, p.number_of_people as numberOfPeople, p.status as status, " +
                "p.request_date as requestDate, p.trip_start_date as tripStartDate, " +
                "p.trip_end_date as tripEndDate, p.total_cost as totalCost, p.client_id as client, " +
                "p.user_id as user, d.code as destinationCode, d.name as destinationName " +
                "FROM plan_detail_plan pdp " +
                "JOIN plan_detail pd ON pdp.id_plan_detail = pd.id " +
                "JOIN plan p ON pdp.id_plan = p.id " +
                "JOIN destination d ON pd.destination_id = d.id " +
                "WHERE p.status = 'Active'", resultSetMapping = "Mapping.PlanDetailDestinationDTO")

@SqlResultSetMapping(name = "Mapping.DestinationChartTypeDTO",
        classes = @ConstructorResult(targetClass = DestinationChartTypeDTO.class,
                columns = {@ColumnResult(name = "name"),
                        @ColumnResult(name = "number")}))
@SqlResultSetMapping(name = "Mapping.DestinationTopDTO",
        classes = @ConstructorResult(targetClass = DestinationTopDTO.class,
                columns = {@ColumnResult(name = "name"),
                        @ColumnResult(name = "description"),
                        @ColumnResult(name = "image")}))
@SqlResultSetMapping(name = "Mapping.PlanDetailDestinationDTO",
        classes = @ConstructorResult(targetClass = PlanDetailDestinationDTO.class,
                columns = {
                        @ColumnResult(name = "id"),
                        @ColumnResult(name = "code"),
                        @ColumnResult(name = "description"),
                        @ColumnResult(name = "name"),
                        @ColumnResult(name = "numberOfPeople"),
                        @ColumnResult(name = "status"),
                        @ColumnResult(name = "requestDate"),
                        @ColumnResult(name = "tripStartDate"),
                        @ColumnResult(name = "tripEndDate"),
                        @ColumnResult(name = "totalCost"),
                        @ColumnResult(name = "client"),
                        @ColumnResult(name = "user"),
                        @ColumnResult(name = "destinationCode"),
                        @ColumnResult(name = "destinationName")}))


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
