package co.anilozturk.isparkservice.park;

import co.anilozturk.isparkservice.park.model.ParkLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ParkLocationRepository extends JpaRepository<ParkLocation, Integer> {
}
