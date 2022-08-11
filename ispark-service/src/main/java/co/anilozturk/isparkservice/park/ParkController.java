package co.anilozturk.isparkservice.park;

import co.anilozturk.isparkservice.park.model.ParkLocationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ispark")
public class ParkController {

    private final ParkService parkService;

    public ParkController(ParkService parkService) {
        this.parkService = parkService;
    }

    @GetMapping
    public ResponseEntity<List<ParkLocationDto>> getAllParkLocations(){

        return ResponseEntity.ok().body(parkService.getAllParks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkLocationDto> getParkDetails(@PathVariable Integer id){

        return ResponseEntity.ok().body(parkService.getParkDetails(id));
    }
}
