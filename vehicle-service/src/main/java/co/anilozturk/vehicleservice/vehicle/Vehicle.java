package co.anilozturk.vehicleservice.vehicle;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Vehicle {

    @Id
    private String plate;

    private String brand;

    private String model;

    private Long engineCapacity;
}
