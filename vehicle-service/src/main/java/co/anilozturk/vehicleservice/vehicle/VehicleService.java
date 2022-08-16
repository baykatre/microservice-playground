package co.anilozturk.vehicleservice.vehicle;

import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle getVehicleByPlate(String plate){
        return vehicleRepository.findById(plate).orElseThrow(() -> new RuntimeException("Araç bulunamadı!"));
    }
}
