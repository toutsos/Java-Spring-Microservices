package org.toutsos.customer;

import lombok.extern.slf4j.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrattionRequest customerRequest){
        log.info("New Customer Registration {}",customerRequest);
        customerService.registerCustomer(customerRequest);
    }
}
