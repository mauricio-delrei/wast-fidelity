package com.wasp.fidelity.church_secretaria_service.presentation.dto.request;

import com.wasp.fidelity.church_secretaria_service.domain.enums.MemberStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record MemberRequest(

        @NotBlank(message = "Full name is required")
        String fullName,

        @Past(message = "Date of birth must be in the past")
        LocalDate dateOfBirth,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        @NotBlank(message = "Mobile phone is required")
        @Email(message = "Mobile phone must be valid")
        String mobilePhone,

        @Past(message = "Baptism date must be in the past")
        LocalDate baptismDate,

        MemberStatus status,

        AddressRequest address
) {
}