package co.anilozturk.feignclient.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ParkLocationDetailDto extends ParkLocationDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime updateDateTime;

    private Double monthlySubscriptionPrice;

    private String address;

    private String tariffs;
}
