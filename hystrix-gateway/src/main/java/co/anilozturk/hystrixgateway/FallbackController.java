package co.anilozturk.hystrixgateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fb")
public class FallbackController {

    @GetMapping("/park")
    public ResponseEntity<String> fbParkController(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is not reachable park service!");
    }

    @GetMapping("/vehicle")
    public ResponseEntity<String> fbVehicleController(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is not reachable vehicle service!");
    }
}
