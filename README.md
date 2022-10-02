# Microservice Playground

Is a Spring Boot microservice app to getting real Ispark (Istanbul Metropolian Municipality official parking service) locations and park a vehicle to there.

### Prerequisites

- Docker
- Java 11

Make sure export jar via maven, before run docker-compose file.

```
mvn clean install -DskipTests
```

### Run

```
docker compose up docs/deployment-docker-compose.yml -d
```

### Use

- To get all park locations
```
curl --location --request GET 'localhost:8088/ispark/'
```
- To get specific park location
```
curl --location --request GET 'localhost:8088/ispark/{PARK_LOCATION_ID}'
```
- To park a vehicle to a parking space
```
curl --location --request POST 'localhost:8088/parking?plate={PLATE}&placeId={PARK_LOCATION_ID}'
```

### Structure

![Structure](https://github.com/baykatre/microservice-playground/blob/main/docs/structure.png?raw=true "Structure")

### View

- Docker Desktop
![Docker Desktop](https://github.com/baykatre/microservice-playground/blob/main/docs/docker-desktop.png?raw=true "Docker Desktop")


- Eureka
```
localhost:1380/eureka
```
![Eureka](https://github.com/baykatre/microservice-playground/blob/main/docs/eureka.png?raw=true "Eureka")


- Zipkin
```
localhost:9411/
```
![Zipkin](https://github.com/baykatre/microservice-playground/blob/main/docs/zipkin.png?raw=true "Zipkin")


- Admin Server
```
localhost:1379/
```
![Admin Server Wallboard](https://github.com/baykatre/microservice-playground/blob/main/docs/admin-server.png?raw=true "Admin Service Wallboard")
![Admin Server Applications](https://github.com/baykatre/microservice-playground/blob/main/docs/admin-server2.png?raw=true "Admin Service Applications")

## Authors

- **Anıl Öztürk** - _Software Developer_ - [GitHub](https://github.com/baykatre)

## Thanks

[Microservice App Tutorial](https://github.com/HaydiKodlayalim/microservice-app) by [temelt](https://github.com/temelt)