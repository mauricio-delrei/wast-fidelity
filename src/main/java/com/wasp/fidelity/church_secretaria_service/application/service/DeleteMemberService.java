package com.wasp.fidelity.church_secretaria_service.application.service;

import com.wasp.fidelity.church_secretaria_service.application.port.in.DeleteMemberUseCase;
import com.wasp.fidelity.church_secretaria_service.application.port.out.MemberRepository;
import com.wasp.fidelity.church_secretaria_service.exception.MemberNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteMemberService implements DeleteMemberUseCase {

    private final MemberRepository repository;

    public DeleteMemberService(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(UUID id) {
        var member = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));

        repository.delete(member);

    }
}
