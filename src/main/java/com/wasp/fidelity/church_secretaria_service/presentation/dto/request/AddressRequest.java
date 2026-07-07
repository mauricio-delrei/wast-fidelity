package com.wasp.fidelity.church_secretaria_service.presentation.dto.request;

public record AddressRequest(
        String street,
        String city,
        String postcode,
        String country
    ){}

