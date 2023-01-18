package org.toutsos.fraud;

import lombok.*;
import org.springframework.stereotype.*;

import java.time.*;

@Service
@AllArgsConstructor
public class FraudCheckHistoryService {

    private final FraudCheckHistoryRepository repository;

    public boolean isFraudulentCustomer(Integer customerId){
        repository.save(
                FraudCheckHistory.builder()
                        .isFraudster(false)
                        .customerId(customerId)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }

}
