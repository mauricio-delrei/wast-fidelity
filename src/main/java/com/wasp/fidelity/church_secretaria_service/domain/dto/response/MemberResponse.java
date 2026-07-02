package com.wasp.fidelity.church_secretaria_service.domain.dto.response;

import com.wasp.fidelity.church_secretaria_service.domain.enums.MemberStatus;

import java.time.LocalDate;

public record MemberResponse(

        Long id,
        String fullName,
        String email,
        LocalDate dateOfBirth,
        String mobilePhone,
        LocalDate baptismDate,
        MemberStatus status,
        AddressResponse address

) {
}