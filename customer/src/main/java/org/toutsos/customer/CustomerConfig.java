package org.toutsos.customer;

import org.springframework.context.annotation.*;
import org.springframework.web.client.*;

@Configuration
public class CustomerConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
