package com.wasp.fidelity.church_secretaria_service.presentation.dto.request;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;


@Getter
public class RegisterBaptizedMemberRequest {


    private String fullName;

    private String email;

    private String mobilePhone;

    private LocalDate dateOfBirth;

    private LocalDate baptismDate;

    private String address;
}
