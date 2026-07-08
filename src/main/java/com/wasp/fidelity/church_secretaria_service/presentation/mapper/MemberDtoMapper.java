package com.wasp.fidelity.church_secretaria_service.presentation.mapper;

import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.request.MemberRequest;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.response.MemberResponse;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class MemberDtoMapper {

    @Autowired
    protected AddressDtoMapper addressDtoMapper;

    public Member toDomain(MemberRequest request) {

        if (request == null) {
            return null;
        }

        return Member.create(
                request.fullName(),
                request.email(),
                request.mobilePhone(),
                request.dateOfBirth(),
                request.baptismDate(),
                addressDtoMapper.toDomain(request.address())
        );
    }
    public Member toDomainForUpdate(MemberRequest request) {

        if (request == null) {
            return null;
        }

        return Member.builder()
                .fullName(request.fullName())
                .email(request.email())
                .mobilePhone(request.mobilePhone())
                .dateOfBirth(request.dateOfBirth())
                .baptismDate(request.baptismDate())
                .status(request.status())
                .address(addressDtoMapper.toDomain(request.address()))
                .build();
    }

    public abstract MemberResponse toResponse(Member member);
}


