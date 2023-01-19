package org.toutsos.clients.fraud;

import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

/*
    So with this impl oif feign each microservice that wants to comunicate
    with Fraud can use this Interface instead of commmunicate directly
    with the Fraud controller.
 */
@FeignClient ("fraud")
public interface FraudClient {
    @GetMapping(path = "api/v1/fraud-check/{customerId}")
    FraudCheckResponce isFraudster(
            @PathVariable("customerId") Integer customerId );

}
