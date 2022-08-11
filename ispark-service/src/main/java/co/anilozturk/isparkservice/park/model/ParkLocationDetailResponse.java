package co.anilozturk.isparkservice.park.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ParkLocationDetailResponse extends ParkLocationResponse{

    @JsonProperty("updateDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime updateDateTime;

    @JsonProperty("monthlyFee")
    private Double monthlySubscriptionPrice;

    @JsonProperty("address")
    private String address;

    @JsonProperty("tariff")
    private String tariffs;
}
