package com.wasp.fidelity.church_secretaria_service.domain.model;


import java.util.Objects;

public record Address(String street, String houseNumber, String city, String postcode, String country,
                      String complement) {}