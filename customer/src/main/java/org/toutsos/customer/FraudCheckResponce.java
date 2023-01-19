package org.toutsos.customer;

/*
    We dont need anymore this class because we used SpringFeign to implement only 1 time the FraudCheckResponse.class
    Otherwise we had to add this class in every microservice in which we would call Fraud
 */
public record FraudCheckResponce(Boolean isFraudster) {
}
