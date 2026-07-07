package com.wasp.fidelity.church_secretaria_service.presentation.dto.response;

public record AddressResponse(
    String street,
    String houseNumber,
    String complement,
    String city,
    String country,
    String postcode
) {

}
