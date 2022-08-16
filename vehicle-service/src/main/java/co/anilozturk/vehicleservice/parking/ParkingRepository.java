package co.anilozturk.vehicleservice.parking;

import co.anilozturk.vehicleservice.parking.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, String> {
}
