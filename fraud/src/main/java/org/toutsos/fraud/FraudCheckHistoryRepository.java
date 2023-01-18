package org.toutsos.fraud;

import org.springframework.data.jpa.repository.*;

public interface FraudCheckHistoryRepository
        extends JpaRepository<FraudCheckHistory,Integer> {
}
