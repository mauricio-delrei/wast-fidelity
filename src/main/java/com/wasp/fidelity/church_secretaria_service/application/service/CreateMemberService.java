package com.wasp.fidelity.church_secretaria_service.application.service;

import com.wasp.fidelity.church_secretaria_service.application.port.in.CreateMemberUseCase;
import com.wasp.fidelity.church_secretaria_service.application.port.out.MemberRepository;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;

import com.wasp.fidelity.church_secretaria_service.exception.BusinessRuleException;
import org.springframework.stereotype.Service;

@Service
public class CreateMemberService implements CreateMemberUseCase {

    private final MemberRepository repository;

    public CreateMemberService(MemberRepository repository) {
        this.repository = repository;
    }
    @Override
    public Member execute(Member member) {
        if(repository.existsByEmail(member.getEmail())) {
            throw new BusinessRuleException("Email already exists.");
        }
        return repository.save(member);
    }
}
