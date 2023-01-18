package org.toutsos.customer;

import org.springframework.stereotype.*;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrattionRequest request){
        Customer customer = Customer
                .builder()
                .firstname(request.firstName())
                .lastname(request.lastName())
                .email(request.email())
                .build();
        //TOOD: Check validation
        customerRepository.save(customer);
    }
}
