package co.edu.icesi.viajes.proyectoicesiviajes.domain;

import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationTopDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationTypeDTO;
import co.edu.icesi.viajes.proyectoicesiviajes.dto.DestinationTypeSimpleDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@NamedNativeQuery(name = "Destination.getTypes",
        query = "Select dt.name as name, dt.description as description from destination_destination_type dtt join destination_type dt on dtt.id_destination_type = dt.id WHERE dtt.id_destination = ?1",
        resultSetMapping = "Mapping.DestinationTypeSimpleDTO")
@SqlResultSetMapping(name = "Mapping.DestinationTypeSimpleDTO",
        classes = @ConstructorResult(targetClass = DestinationTypeSimpleDTO.class,
                columns = {@ColumnResult(name = "name"),
                        @ColumnResult(name = "description")}))
@Entity
@Table(name = "destination")
@ToString
@Getter
@Setter
@Data
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "by_land")
    private String byLand;

    @Column(name = "by_sea")
    private String bySea;

    @Column(name = "by_air")
    private String byAir;

    @Column(name = "status")
    private String status;

    @Column(name = "image")
    private String image;
}
