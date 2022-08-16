package co.anilozturk.vehicleservice.parking;

import co.anilozturk.feignclient.IsparkServiceClient;
import co.anilozturk.feignclient.dto.ParkLocationDto;
import co.anilozturk.feignclient.dto.ParkingNotificationDto;
import co.anilozturk.vehicleservice.parking.model.Parking;
import co.anilozturk.feignclient.dto.ParkingDto;
import co.anilozturk.vehicleservice.parking.model.ParkingMapper;
import co.anilozturk.vehicleservice.vehicle.Vehicle;
import co.anilozturk.vehicleservice.vehicle.VehicleService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    @Value("${rabbit.queue}")
    private String queueName;

    @Value("${rabbit.exchange}")
    private String exchangeName;

    @Value("${rabbit.routingKey}")
    private String routingKey;

    private final ParkingRepository parkingRepository;

    private final VehicleService vehicleService;

    private final IsparkServiceClient isparkServiceClient;

    private final RabbitTemplate rabbitTemplate;

    public ParkingService(ParkingRepository parkingRepository,
                          VehicleService vehicleService,
                          IsparkServiceClient isparkServiceClient, RabbitTemplate rabbitTemplate) {
        this.parkingRepository = parkingRepository;
        this.vehicleService = vehicleService;
        this.isparkServiceClient = isparkServiceClient;
        this.rabbitTemplate = rabbitTemplate;
    }

    public ParkingDto park(String plate, Integer placeId) {

        final Vehicle vehicle = vehicleService.getVehicleByPlate(plate);

        final ResponseEntity<ParkLocationDto> parkLocationDtoResponseEntity = isparkServiceClient.get(placeId);

        if(!HttpStatus.OK.equals(parkLocationDtoResponseEntity.getStatusCode())){
            throw new RuntimeException("Bad Feign Call!");
        }

        final ParkLocationDto parkLocationDto = parkLocationDtoResponseEntity.getBody();

        final Parking parking = parkingRepository.save(Parking.builder().vehicle(vehicle).placeId(parkLocationDto.getId()).build());

        ParkingNotificationDto parkingNotificationDto = ParkingNotificationDto.builder().plate(vehicle.getPlate()).placeId(parkLocationDto.getId()).build();
        rabbitTemplate.convertAndSend(exchangeName, routingKey, parkingNotificationDto);
        return ParkingMapper.INSTANCE.convertToParkingDto(parking);
    }
}
