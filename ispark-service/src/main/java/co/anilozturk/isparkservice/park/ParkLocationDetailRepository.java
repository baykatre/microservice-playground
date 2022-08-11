package co.anilozturk.isparkservice.park;

import co.anilozturk.isparkservice.park.model.ParkLocation;
import co.anilozturk.isparkservice.park.model.ParkLocationDetail;
import co.anilozturk.isparkservice.park.model.ParkLocationDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkLocationDetailRepository extends JpaRepository<ParkLocationDetail, Integer> {
}
