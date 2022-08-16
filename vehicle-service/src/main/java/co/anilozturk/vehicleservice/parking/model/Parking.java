package co.anilozturk.vehicleservice.parking.model;

import co.anilozturk.vehicleservice.vehicle.Vehicle;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "parking")
public class Parking {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @ManyToOne
    private Vehicle vehicle;

    private Integer placeId;
}
