package co.anilozturk.cloudgateway.config;

import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.time.Duration.ofSeconds;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(r -> r.path("/ispark/**")
                        .filters(f -> f.circuitBreaker(h -> h.setName("Ispark Service")
                                .setFallbackUri("forward:/fb/park")))
                        //.filters(f -> f.rewritePath("/ispark/(?<segment>.*)","/${segment}"))
                        .uri("lb://ISPARK-SERVICE"))
                .route(r -> r.path("/parking/**")
                        .filters(f -> f.circuitBreaker(h -> h.setName("Vehicle Service")
                                .setFallbackUri("forward:/fb/vehicle")))
                        //.filters(f -> f.rewritePath("/parking/(?<segment>.*)","/${segment}"))
                        .uri("lb://VEHICLE-SERVICE"))
                .build();
    }

    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> slowConfig() {
        return factory -> factory
                .configure(bld -> bld
                                .timeLimiterConfig(TimeLimiterConfig.custom()
                                        .timeoutDuration(ofSeconds(7))
                                        .build()),
                        "route_slow"
                );
    }
}
