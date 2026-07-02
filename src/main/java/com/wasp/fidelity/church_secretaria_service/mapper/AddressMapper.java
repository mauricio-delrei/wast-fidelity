package com.wasp.fidelity.church_secretaria_service.mapper;

import com.wasp.fidelity.church_secretaria_service.domain.entity.Address;
import com.wasp.fidelity.church_secretaria_service.domain.dto.request.AddressRequest;

public class AddressMapper {

    public static Address toEntity(AddressRequest dto) {
        if (dto == null) return null;

        return Address.builder()
                .streetName(dto.streetName())
                .houseNumber(dto.houseNumber())
                .city(dto.city())
                .county(dto.county())
                .postcode(dto.postcode())
                .build();
    }
}