package org.toutsos.notification;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.netflix.eureka.*;
import org.springframework.context.annotation.*;
import org.toutsos.amqp.*;

@SpringBootApplication(
        scanBasePackages = {
                "org.toutsos.notification",
                "org.toutsos.amqp",
        }
)
@EnableEurekaClient
public class NotificationApplication {
        public static void main(String[] args) {
            SpringApplication.run(NotificationApplication.class, args);
        }
// This is a test to see if RabbitMQ working
//        @Bean
//        CommandLineRunner commandLineRunner(
//            RabbitMQMessageProducer producer,
//            NotificationConfig notificationConfig
//            ) {
//        return args -> {
//            producer.publish(
//                    new Person("Ali", 18),
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }
//
//    record Person(String name, int age){}

}
