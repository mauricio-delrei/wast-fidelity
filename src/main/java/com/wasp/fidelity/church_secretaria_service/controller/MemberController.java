package com.wasp.fidelity.church_secretaria_service.controller;

import com.wasp.fidelity.church_secretaria_service.domain.dto.request.MemberRequest;
import com.wasp.fidelity.church_secretaria_service.domain.dto.response.ApiResponse;
import com.wasp.fidelity.church_secretaria_service.domain.dto.response.MemberResponse;
import com.wasp.fidelity.church_secretaria_service.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ApiResponse<MemberResponse>> create(
            @Valid @RequestBody MemberRequest request) {

        MemberResponse member = service.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        201,
                        "Member created successfully",
                        member));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<ApiResponse<List<MemberResponse>>> findAll() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Members retrieved successfully",
                        service.findAll()));
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MemberResponse>> findById(@PathVariable Long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Member retrieved successfully",
                        service.findById(id)));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MemberResponse>> update(
            @PathVariable Long id,
            @Valid @RequestBody MemberRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Member updated successfully",
                        service.update(id, request)));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Member deleted successfully",
                        null));
    }

    // HEALTH
    @GetMapping("/health")
    public ResponseEntity<ApiResponse<String>> health() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Service is healthy",
                        "OK"));
    }
}