package com.wasp.fidelity.church_secretaria_service.controller;

import com.wasp.fidelity.church_secretaria_service.domain.Member;
import com.wasp.fidelity.church_secretaria_service.domain.dto.request.MemberRequest;
import com.wasp.fidelity.church_secretaria_service.domain.dto.response.MemberResponse;
import com.wasp.fidelity.church_secretaria_service.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping
    public MemberResponse create(@Valid @RequestBody MemberRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<MemberResponse> findAll() {
        return service.findAll();
    }
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
