package co.anilozturk.isparkservice.park.model;

import co.anilozturk.feignclient.dto.ParkLocationDetailDto;
import co.anilozturk.feignclient.dto.ParkLocationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParkMapper {

    ParkMapper INSTANCE = Mappers.getMapper(ParkMapper.class);

    @Mapping(source = "parkType", target = "parkType", qualifiedByName = "mapToParkType")
    ParkLocationDto convertToParkLocationDto(ParkLocationResponse parkLocationResponse);

    ParkLocation convertToParkLocation(ParkLocationDto parkLocationDto);

    ParkLocationDto convertToParkLocationDto(ParkLocation parkLocation);

    ParkLocationDetailDto convertToParkLocationDetailDto(ParkLocationDetailResponse parkLocationDetailResponse);
    @Mapping(source = "parkType", target = "parkType", qualifiedByName = "mapToParkType")
    ParkLocationDetail convertToParkDetailLocation(ParkLocationDetailDto parkLocationDetailDto);
    @Mapping(source = "parkType.name", target = "parkType")
    ParkLocationDetailDto convertToParkLocationDetailDto(ParkLocationDetail parkLocationDetail);

    @Named("mapToParkType")
    public static ParkType mapToParkType(String name) {

        return ParkType.getFromName(name);
    }
}
