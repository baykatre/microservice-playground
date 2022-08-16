package co.anilozturk.feignclient;

import co.anilozturk.feignclient.dto.ParkLocationDto;
import co.anilozturk.feignclient.dto.ParkingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ispark-service")
public interface IsparkServiceClient {

    @GetMapping("/ispark/{id}")
    ResponseEntity<ParkLocationDto> get(@PathVariable Integer id);
}
