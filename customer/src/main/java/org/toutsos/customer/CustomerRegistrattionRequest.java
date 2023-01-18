package org.toutsos.customer;

public record CustomerRegistrattionRequest(
        String firstName,
        String lastName,
        String email
) {}
