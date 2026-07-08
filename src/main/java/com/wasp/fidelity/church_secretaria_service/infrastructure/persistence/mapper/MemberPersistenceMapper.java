package com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.mapper;

import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.entity.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(
        componentModel = "spring",
        uses = {AddressPersistenceMapper.class}
)
public interface MemberPersistenceMapper {

    @Mapping(target = "deactivatedAt", source = "deactivatedAt")
    MemberEntity toEntity(Member domain);

    @Mapping(target = "deactivatedAt", source = "deactivatedAt")
    Member toDomain(MemberEntity entity);
}
