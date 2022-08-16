package co.anilozturk.feignclient.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
public class ParkingNotificationDto implements Serializable {

    private String plate;

    private Integer placeId;
}
