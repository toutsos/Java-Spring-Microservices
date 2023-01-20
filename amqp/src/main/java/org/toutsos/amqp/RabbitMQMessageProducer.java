package org.toutsos.amqp;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.amqp.core.*;
import org.springframework.stereotype.*;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQMessageProducer {

    /*
        This is tha class that is going to be used for sending Messages

        - The logic is as following:
        1. Our customer microservice (producer) sends a message to the exchange
        2. This message contains
            1) payload (actual information)
            2) the exchange
            3) the routing key
        3. The exchange is the one that recieves the message and based on the binding we have done decides
           in which queue to forward the message.
        4. The message reaches the queue and when is can be done is forwarded to Notication.class (consumer)
     */
    private final AmqpTemplate amqpTemplate;

    public void publish (Object payload, String exchange, String routingKey) {
        log.info("Before: Publishing to {} using routing-key {}, Payload: {}",exchange,routingKey,payload);
        amqpTemplate.convertAndSend(exchange,routingKey,payload);
        log.info("After: Publishing to {} using routing-key {}, Payload: {}",exchange,routingKey,payload);

    }

}
