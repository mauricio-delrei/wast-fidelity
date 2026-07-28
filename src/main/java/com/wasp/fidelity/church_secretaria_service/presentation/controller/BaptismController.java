package com.wasp.fidelity.church_secretaria_service.presentation.controller;

import com.wasp.fidelity.church_secretaria_service.application.command.RegisterBaptizedMemberCommand;
import com.wasp.fidelity.church_secretaria_service.application.port.in.RegisterBaptizedMemberUseCase;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.request.CreateMemberRequest;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.request.RegisterBaptizedMemberRequest;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.response.MemberResponse;
import com.wasp.fidelity.church_secretaria_service.presentation.mapper.AddressDtoMapper;
import com.wasp.fidelity.church_secretaria_service.presentation.mapper.MemberDtoMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/members")
public class BaptismController {


    private final RegisterBaptizedMemberUseCase registerBaptizedMemberUseCase;

    private final MemberDtoMapper memberDtoMapper;

    private final AddressDtoMapper addressDtoMapper;



    public BaptismController(
            RegisterBaptizedMemberUseCase registerBaptizedMemberUseCase,
            MemberDtoMapper memberDtoMapper,
            AddressDtoMapper addressDtoMapper
    ) {
        this.registerBaptizedMemberUseCase = registerBaptizedMemberUseCase;
        this.memberDtoMapper = memberDtoMapper;
        this.addressDtoMapper = addressDtoMapper;
    }



    @PostMapping("/baptism")
    public ResponseEntity<MemberResponse> registerBaptism(
            @Valid @RequestBody CreateMemberRequest request
    ) {


        RegisterBaptizedMemberCommand command =
                RegisterBaptizedMemberCommand.builder()
                        .fullName(request.getFullName())
                        .email(request.getEmail())
                        .mobilePhone(request.getMobilePhone())
                        .dateOfBirth(request.getDateOfBirth())
                        .baptismDate(request.getBaptismDate())
                        .address(
                                addressDtoMapper.toDomain(
                                        request.getAddress()
                                )
                        )
                        .build();



        Member member =
                registerBaptizedMemberUseCase.execute(command);



        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        memberDtoMapper.toResponse(member)
                );
    }
}
