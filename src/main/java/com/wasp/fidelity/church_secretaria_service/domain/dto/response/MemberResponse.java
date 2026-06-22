package com.wasp.fidelity.church_secretaria_service.domain.dto.response;

import java.time.LocalDate;

public record MemberResponse(
        Long id,
        String fullName,
        String email,
        LocalDate dateOfBirth,
        String mobilePhone,
        LocalDate baptismDate
) {
}
