package org.toutsos.customer;

import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
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
        FraudCheckResponce fraudCheckResponce = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponce.class,
                customer.getId()
        );

        if (fraudCheckResponce.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

        //TODO: send notification
    }
}
