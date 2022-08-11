package co.anilozturk.isparkservice.park.model;

import lombok.Getter;

import java.util.Arrays;
@Getter
public enum ParkType {

    ON_ROAD("YOL ÜSTÜ"), OPEN("AÇIK OTOPARK"), CLOSE("KAPALI OTOPARK");

    private String name;

    ParkType(String name) {
        this.name = name;
    }

    public static ParkType getFromName(String name){
        return Arrays.stream(ParkType.values())
                .filter(shipmentStatus -> shipmentStatus.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}
