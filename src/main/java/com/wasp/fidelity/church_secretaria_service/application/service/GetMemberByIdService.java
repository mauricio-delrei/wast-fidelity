package com.wasp.fidelity.church_secretaria_service.application.service;

import com.wasp.fidelity.church_secretaria_service.application.port.in.GetMemberByIdUseCase;
import com.wasp.fidelity.church_secretaria_service.application.port.out.MemberRepository;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.exception.MemberNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetMemberByIdService implements GetMemberByIdUseCase {

    private final MemberRepository repository;

    public GetMemberByIdService(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public Member execute(UUID id) {
        return repository.findById(id).orElseThrow(()-> new MemberNotFoundException(id));
    }
}
