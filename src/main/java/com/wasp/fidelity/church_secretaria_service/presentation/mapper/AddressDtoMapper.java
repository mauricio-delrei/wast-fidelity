package com.wasp.fidelity.church_secretaria_service.presentation.mapper;

import com.wasp.fidelity.church_secretaria_service.domain.model.Address;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.request.AddressRequest;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.response.AddressResponse;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AddressDtoMapper {


    Address toDomain(AddressRequest request);

    AddressResponse toResponse(Address domain);
}
