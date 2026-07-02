package com.wasp.fidelity.church_secretaria_service.domain.dto.response;

public record AddressResponse(
    String streetName,
    String houseNumber,
    String complement,
    String city,
    String county,
    String postcode
) {

}
