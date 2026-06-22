package com.wasp.fidelity.church_secretaria_service.mapper;

import com.wasp.fidelity.church_secretaria_service.domain.Member;
import com.wasp.fidelity.church_secretaria_service.domain.dto.request.MemberRequest;
import com.wasp.fidelity.church_secretaria_service.domain.dto.response.MemberResponse;

public class MemberMapper {

    public static Member toEntity(MemberRequest request){
        return Member.builder()
                .fullName(request.fullName())
                .email(request.email())
                .dateOfBirth(request.dateOfBirth())
                .mobilePhone(request.mobilePhone())
                .baptismDate(request.baptismDate())
                .build();
    }
    public static MemberResponse toResponse(Member member){
        return new MemberResponse(
                member.getId(),
                member.getFullName(),
                member.getEmail(),
                member.getDateOfBirth(),
                member.getMobilePhone(),
                member.getBaptismDate()
        );
    }

}
