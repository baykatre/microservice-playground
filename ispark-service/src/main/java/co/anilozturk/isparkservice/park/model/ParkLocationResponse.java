package co.anilozturk.isparkservice.park.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkLocationResponse {

    @JsonProperty("parkID")
    private Integer id;

    @JsonProperty("parkName")
    private String name;

    @JsonProperty("lat")
    private Double latitude;

    @JsonProperty("lng")
    private Double longitude;

    @JsonProperty("capacity")
    private Integer totalCapacity;

    @JsonProperty("emptyCapacity")
    private Integer freeCapacity;

    @JsonProperty("parkType")
    private String parkType;

    @JsonProperty("district")
    private String district;

    @JsonProperty("freeTime")
    private Integer freeParkingTime;

    @JsonProperty("isOpen")
    private Boolean isOpen;

    @JsonProperty("workHours")
    private String workHours;

}
