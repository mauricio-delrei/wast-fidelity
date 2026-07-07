package com.wasp.fidelity.church_secretaria_service.presentation.dto.response;

import com.wasp.fidelity.church_secretaria_service.domain.enums.MemberStatus;

import java.time.LocalDate;
import java.util.UUID;

public record MemberResponse(

        UUID id,
        String fullName,
        String email,
        LocalDate dateOfBirth,
        String mobilePhone,
        LocalDate baptismDate,
        MemberStatus status,
        AddressResponse address

) {
}