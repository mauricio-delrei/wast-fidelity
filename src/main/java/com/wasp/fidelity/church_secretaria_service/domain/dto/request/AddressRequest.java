package com.wasp.fidelity.church_secretaria_service.domain.dto.request;

public record AddressRequest(
        String streetName,
        String houseNumber,
        String city,
        String county,
        String postcode
    ){}

