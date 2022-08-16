package co.anilozturk.vehicleservice.parking.model;

import co.anilozturk.feignclient.dto.ParkingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParkingMapper {

    ParkingMapper INSTANCE = Mappers.getMapper(ParkingMapper.class);
    @Mapping(source = "vehicle.plate", target = "plate")
    ParkingDto convertToParkingDto(Parking parking);
}
