package co.anilozturk.isparkservice.park;

import co.anilozturk.isparkservice.park.model.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParkService {

    private final WebClient webClient;

    private final ParkLocationRepository parkLocationRepository;

    private final ParkLocationDetailRepository parkLocationDetailRepository;


    public ParkService(WebClient webClient, ParkLocationRepository parkLocationRepository, ParkLocationDetailRepository parkLocationDetailRepository) {
        this.webClient = webClient;
        this.parkLocationRepository = parkLocationRepository;
        this.parkLocationDetailRepository = parkLocationDetailRepository;
    }

    List<ParkLocationDto> getAllParks(){

        final List<ParkLocation> parkLocation = parkLocationRepository.findAll();

        final List<ParkLocationDto> parkLocationDtoList = CollectionUtils.isEmpty(parkLocation)
                ? getParkLocationDtoList()
                : parkLocation.stream()
                            .map(ParkMapper.INSTANCE::convertToParkLocationDto)
                            .collect(Collectors.toList());

        return parkLocationDtoList;

    }

    public ParkLocationDetailDto getParkDetails(Integer id) {

        final Optional<ParkLocationDetail> parkLocationDetailOpt = parkLocationDetailRepository.findById(id);

        if(parkLocationDetailOpt.isPresent()){
            return ParkMapper.INSTANCE.convertToParkLocationDetailDto(parkLocationDetailOpt.get());
        }

        return getParkDetailsByService(id);
    }

    private ParkLocationDetailDto getParkDetailsByService(Integer id) {

        Flux<ParkLocationDetailResponse> parkLocationDetailResponseMono = webClient
                .get()
                .uri("/ParkDetay?id={1}", id)
                .retrieve()
                .bodyToFlux(ParkLocationDetailResponse.class);

        ParkLocationDetailResponse parkLocationDetailResponse = parkLocationDetailResponseMono.blockFirst();
        ParkLocationDetailDto parkLocationDetailDto = ParkMapper.INSTANCE.convertToParkLocationDetailDto(parkLocationDetailResponse);
        parkLocationDetailRepository.save(ParkMapper.INSTANCE.convertToParkDetailLocation(parkLocationDetailDto));

        return parkLocationDetailDto;
    }

    private List<ParkLocationDto> getParkLocationDtoList() {


        final Flux<ParkLocationResponse> parkLocationDtoFlux = webClient
                .get()
                .uri("/Park")
                .retrieve()
                .bodyToFlux(ParkLocationResponse.class);

        final List<ParkLocationDto> parkLocationDtoList = parkLocationDtoFlux
                .toStream()
                .map(parkLocationResponse -> ParkMapper.INSTANCE.convertToParkLocationDto(parkLocationResponse))
                .collect(Collectors.toList());

        parkLocationRepository.saveAll(parkLocationDtoList
                .stream()
                .map(ParkMapper.INSTANCE::convertToParkLocation)
                .collect(Collectors.toList()));
        return parkLocationDtoList;
    }
}
