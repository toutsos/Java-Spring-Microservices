package org.toutsos.amqp;

import com.rabbitmq.client.*;
import lombok.*;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.*;
import org.springframework.amqp.support.converter.*;
import org.springframework.context.annotation.*;

@Configuration
@AllArgsConstructor
public class RabbitMQConfig {

    private final ConnectionFactory connectionFactory;

    /*
    THis allow us to SEND messages to the queue
     */
    @Bean
    public AmqpTemplate amqpTemplate () {
        RabbitTemplate rabbitTemplate =
                new RabbitTemplate(connectionFactory);
        // We transfrom message from Object to JSON when sent from Producer and transform again to Obj when reaches Consumer
        rabbitTemplate.setMessageConverter(jacksonConverter());
        return rabbitTemplate;
    }

    /*
    THis allow us to RECIEVE messages from the queue
     */
    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(){
        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory =
                new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleRabbitListenerContainerFactory.setMessageConverter(jacksonConverter());
        return simpleRabbitListenerContainerFactory;
    }

    @Bean
    public MessageConverter jacksonConverter () {
        MessageConverter jacksonMessageConverter =
                new Jackson2JsonMessageConverter();
        return jacksonMessageConverter;
    }

}