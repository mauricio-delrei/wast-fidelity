package com.wasp.fidelity.church_secretaria_service.presentation.mapper;

import com.wasp.fidelity.church_secretaria_service.domain.model.Address;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.request.AddressRequest;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.response.AddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressDtoMapper {

    @Mapping(source = "street", target = "street")
    @Mapping(source = "country", target = "country")
    Address toDomain(AddressRequest request);


    @Mapping(source = "street", target = "street")
    @Mapping(source = "country", target = "country")
    AddressResponse toResponse(Address domain);
}
