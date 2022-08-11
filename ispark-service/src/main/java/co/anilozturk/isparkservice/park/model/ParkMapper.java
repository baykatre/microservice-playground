package co.anilozturk.isparkservice.park.model;

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

    @Mapping(source = "parkType", target = "parkType", qualifiedByName = "mapToParkType")
    ParkLocationDetailDto convertToParkLocationDetailDto(ParkLocationDetailResponse parkLocationDetailResponse);

    ParkLocationDetail convertToParkDetailLocation(ParkLocationDetailDto parkLocationDetailDto);

    ParkLocationDetailDto convertToParkLocationDetailDto(ParkLocationDetail parkLocationDetail);

    @Named("mapToParkType")
    public static ParkType mapToParkType(String name) {

        return ParkType.getFromName(name);
    }
}
