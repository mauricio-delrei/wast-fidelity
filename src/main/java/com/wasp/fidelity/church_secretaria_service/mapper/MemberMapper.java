package com.wasp.fidelity.church_secretaria_service.mapper;

import com.wasp.fidelity.church_secretaria_service.domain.entity.Member;
import com.wasp.fidelity.church_secretaria_service.domain.dto.request.MemberRequest;
import com.wasp.fidelity.church_secretaria_service.domain.dto.response.MemberResponse;
import com.wasp.fidelity.church_secretaria_service.domain.dto.response.AddressResponse;

public class MemberMapper {

    public static Member toEntity(MemberRequest request) {
        return Member.builder()
                .fullName(request.fullName())
                .email(request.email())
                .mobilePhone(request.mobilePhone())
                .dateOfBirth(request.dateOfBirth())
                .baptismDate(request.baptismDate())
                .status(request.status())
                .address(AddressMapper.toEntity(request.address()))
                .build();
    }

    public static MemberResponse toResponse(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getFullName(),
                member.getEmail(),
                member.getDateOfBirth(),
                member.getMobilePhone(),
                member.getBaptismDate(),
                member.getStatus(),
                member.getAddress() == null ? null
                        : new AddressResponse(
                                member.getAddress().getStreetName(),
                                member.getAddress().getHouseNumber(),
                                member.getAddress().getComplement(),
                                member.getAddress().getCity(),
                                member.getAddress().getCounty(),
                                member.getAddress().getPostcode()
                        )
        );
    }
}