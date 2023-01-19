package org.toutsos.fraud;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check/")
@Slf4j
public class FraudController {

    //attribute is injected from @AllArgsConstructor
    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponce isFraudster(
            @PathVariable("customerId") Integer customerId ){
        Boolean isFraudulentCustomer =
                fraudCheckHistoryService.isFraudulentCustomer(customerId);
        log.info("fraud check request for customer {}",customerId);
        return new FraudCheckResponce(isFraudulentCustomer);
    }

}
