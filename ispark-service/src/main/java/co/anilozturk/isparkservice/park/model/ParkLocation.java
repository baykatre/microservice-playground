package co.anilozturk.isparkservice.park.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ParkLocation {

    @Id
    private Integer id;

    private String name;

    private Double latitude;

    private Double longitude;

    private Integer totalCapacity;

    private Integer freeCapacity;

    @Enumerated(EnumType.STRING)
    private ParkType parkType;

    private String district;

    private Integer freeParkingTime;

    private Boolean isOpen;

    private String workHours;
}
