package co.anilozturk.hystrixgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class HystrixGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixGatewayApplication.class, args);
    }
}
