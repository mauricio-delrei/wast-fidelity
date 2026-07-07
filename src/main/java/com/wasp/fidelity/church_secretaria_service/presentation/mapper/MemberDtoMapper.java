package com.wasp.fidelity.church_secretaria_service.presentation.mapper;

import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.request.MemberRequest;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.response.MemberResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {AddressDtoMapper.class})
public interface MemberDtoMapper {

    // Request → Domain
    @Mapping(target = "id", ignore = true)
    Member toDomain(MemberRequest request);

    // Domain → Response
    MemberResponse toResponse(Member domain);

}
