package com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.mapper;

import com.wasp.fidelity.church_secretaria_service.domain.model.Address;
import com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AddressPersistenceMapper {



    @Mapping(target = "id", ignore = true)
    AddressEntity toEntity(Address domain);

    Address toDomain(AddressEntity entity);
}
