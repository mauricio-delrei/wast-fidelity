package com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.mapper;

import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.entity.MemberEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",
        builder = @org.mapstruct.Builder(disableBuilder = false),
        uses = {AddressPersistenceMapper.class})
public interface MemberPersistenceMapper {




    MemberEntity toEntity(Member domain);


    Member toDomain(MemberEntity entity);
}
