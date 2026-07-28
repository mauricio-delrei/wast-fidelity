package com.wasp.fidelity.church_secretaria_service.presentation.dto.request;

import com.wasp.fidelity.church_secretaria_service.domain.enums.MemberStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record UpdateMemberRequest(

        String fullName,

        @Past(message = "Date of birth must be in the past")
        LocalDate dateOfBirth,

        @Email(
                regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
                message = "Email must be valid"
        )
        String email,

        String mobilePhone,

        @Past(message = "Baptism date must be in the past")
        LocalDate baptismDate,

        AddressRequest address,

        MemberStatus status

) {
}
