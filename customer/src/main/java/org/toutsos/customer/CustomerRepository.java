package org.toutsos.customer;

import org.springframework.data.jpa.repository.*;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
