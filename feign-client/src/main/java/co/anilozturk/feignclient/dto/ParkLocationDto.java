package co.anilozturk.feignclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkLocationDto {

    private Integer id;

    private String name;

    private Double latitude;

    private Double longitude;

    private Integer totalCapacity;

    private Integer freeCapacity;

    private String parkType;

    private String district;

    private Integer freeParkingTime;

    private Boolean isOpen;

    private String workHours;
}
