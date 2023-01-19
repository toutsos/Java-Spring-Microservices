package org.toutsos.customer;

import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;
import org.toutsos.clients.fraud.*;
import org.toutsos.clients.fraud.FraudCheckResponce;
import org.toutsos.clients.notification.*;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    public void registerCustomer(CustomerRegistrattionRequest request){
        Customer customer = Customer
                .builder()
                .firstname(request.firstName())
                .lastname(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);

        //TODO: Check email validation
        //TODO: Check email not taken
        //TODO: Check if fraudster

        /*
        "http://localhost:8081/api/v1/fraud-check/{customerId}"
            if we want to hardcode the url that this service will communicate
            but in this case we cannot use other instances of this service that we may setup
            for load balancing reasons

        By using FRAUD instead of localhost:8081 we say to the request
            go to EUREKA server
            find clients with FRAUD name
            and get their url
            FRAUD name is from microservices properties.yml -> name field
         */
//        FraudCheckResponce fraudCheckResponce = restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponce.class,
//                customer.getId()
//        );

        /*
            This is the same method with the above but:
                We now are calling an interface instead of directly the controller of Fraud
                We do not have to create FraudCheckResponce.class in each microservice that we need to connect with Fraud
         */
        FraudCheckResponce fraudCheckResponce =
                fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponce.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

        //TODO: make it async
        notificationClient.sendNotification(
                new NotificationRequest(
                customer.getId(),
                String.format("Hi %s welcome to my Spring Microservices Repository",customer.getFirstname()),
                customer.getEmail()
                )
        );
    }
}
