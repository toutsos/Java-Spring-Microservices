package org.toutsos.customer;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.netflix.eureka.*;
import org.springframework.cloud.openfeign.*;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "org.toutsos.clients"
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class,args);
    }
}
