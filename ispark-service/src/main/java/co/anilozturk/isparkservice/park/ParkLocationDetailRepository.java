package co.anilozturk.isparkservice.park;

import co.anilozturk.isparkservice.park.model.ParkLocationDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkLocationDetailRepository extends JpaRepository<ParkLocationDetail, Integer> {
}
