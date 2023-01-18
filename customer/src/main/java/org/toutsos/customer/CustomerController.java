package org.toutsos.customer;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrattionRequest customerRequest){
        log.info("New Customer Registration {}",customerRequest);
        customerService.registerCustomer(customerRequest);
    }
}
