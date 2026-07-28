package com.wasp.fidelity.church_secretaria_service.application.command;

import com.wasp.fidelity.church_secretaria_service.domain.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;



@Getter
@Builder
@AllArgsConstructor
public class RegisterBaptizedMemberCommand {


    private final String fullName;


    private final String email;


    private final String mobilePhone;


    private final LocalDate dateOfBirth;


    private final LocalDate baptismDate;


    private final Address address;
}
