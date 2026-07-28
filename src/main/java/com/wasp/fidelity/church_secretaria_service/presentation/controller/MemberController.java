package com.wasp.fidelity.church_secretaria_service.presentation.controller;


import com.wasp.fidelity.church_secretaria_service.application.port.in.*;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.request.CreateMemberRequest;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.request.UpdateMemberRequest;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.response.ApiResponse;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.response.MemberResponse;
import com.wasp.fidelity.church_secretaria_service.presentation.mapper.MemberDtoMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final CreateMemberUseCase createMemberUseCase;
    private final GetMemberByIdUseCase getMemberByIdUseCase;
    private final GetAllMembersUseCase getAllMembersUseCase;
    private final UpdateMemberUseCase updateMemberUseCase;
    private final DeactivateMemberUseCase deactivateMemberUseCase;

    private final MemberDtoMapper mapper;

    public MemberController(
            CreateMemberUseCase createMemberUseCase,
            GetMemberByIdUseCase getMemberByIdUseCase,
            GetAllMembersUseCase getAllMembersUseCase,
            UpdateMemberUseCase updateMemberUseCase,
            DeactivateMemberUseCase deactivateMemberUseCase,
            MemberDtoMapper mapper
    ) {
        this.createMemberUseCase = createMemberUseCase;
        this.getMemberByIdUseCase = getMemberByIdUseCase;
        this.getAllMembersUseCase = getAllMembersUseCase;
        this.updateMemberUseCase = updateMemberUseCase;
        this.deactivateMemberUseCase = deactivateMemberUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<MemberResponse>>> findAll() {
        List<Member>members = getAllMembersUseCase.execute();

        List<MemberResponse>response = members.stream()
                .map(mapper::toResponse)
                .toList();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Members retrieved successfully",
                        response
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MemberResponse>> findById(@PathVariable UUID id) {

        Member member = getMemberByIdUseCase.execute(id);

        MemberResponse response = mapper.toResponse(member);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Member retrieved successfully",
                        response
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MemberResponse>> create(
            @Valid @RequestBody CreateMemberRequest request) {

        Member member = mapper.toDomain(request);

        Member created = createMemberUseCase.execute(member);

        MemberResponse response = mapper.toResponse(created);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        201,
                        "Member created successfully",
                        response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MemberResponse>> update(@PathVariable UUID id,
                                                              @Valid @RequestBody UpdateMemberRequest request) {

        Member updated = updateMemberUseCase.execute(id,mapper.toDomainForUpdate(request));

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Member updated successfully",
                        mapper.toResponse(updated)
                )
        );

    }
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<ApiResponse<MemberResponse>> deactivate(
            @PathVariable UUID id) {

        Member member = deactivateMemberUseCase.execute(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Member deactivated successfully",
                        mapper.toResponse(member)
                )
        );
    }

}