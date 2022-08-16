package co.anilozturk.vehicleservice.parking;

import co.anilozturk.feignclient.dto.ParkingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @PostMapping
    public ResponseEntity<ParkingDto> park(@RequestParam String plate, @RequestParam Integer placeId){
        return ResponseEntity.ok(parkingService.park(plate, placeId));
    }
}
