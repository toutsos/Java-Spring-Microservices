package org.toutsos.fraud;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.netflix.eureka.*;

@SpringBootApplication
@EnableEurekaClient
public class FraudApplication  {
    public static void main(String[] args) {
        SpringApplication.run(FraudApplication.class,args);
    }
}
