package org.toutsos;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.netflix.eureka.*;
import org.springframework.cloud.openfeign.*;

@SpringBootApplication
@EnableEurekaClient
public class NotificationApplication {
        public static void main(String[] args){
            SpringApplication.run(NotificationApplication.class,args);
        }
}
