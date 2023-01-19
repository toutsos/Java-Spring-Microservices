package org.toutsos.customer;

import org.springframework.cloud.client.loadbalancer.*;
import org.springframework.context.annotation.*;
import org.springframework.web.client.*;

@Configuration
public class CustomerConfig {

    /*
    We used @LoadBalanced annotation because we use Eureka Server
    and the RestTamplate does not know which instance of Client to use each time
    even if there is only one
    We do not need this annotation for hardcoded url -> e.x. localhost:8081
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
