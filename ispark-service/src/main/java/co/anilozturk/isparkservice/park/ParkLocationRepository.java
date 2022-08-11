package co.anilozturk.isparkservice.park;

import co.anilozturk.isparkservice.park.model.ParkLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkLocationRepository extends JpaRepository<ParkLocation, Integer> {
}
