package com.wasp.fidelity.church_secretaria_service.controller;

import com.wasp.fidelity.church_secretaria_service.domain.Member;
import com.wasp.fidelity.church_secretaria_service.service.MemberService;
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
    public Member create(@RequestBody Member member) {
        return service.save(member);
    }

    @GetMapping
    public List<Member> getAll() {
        return service.findAll();
    }
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
