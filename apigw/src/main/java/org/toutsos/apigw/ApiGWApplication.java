package org.toutsos.apigw;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.netflix.eureka.*;

@EnableEurekaClient
@SpringBootApplication
public class ApiGWApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGWApplication.class,args);
    }
}