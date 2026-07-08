package com.wasp.fidelity.church_secretaria_service.application.service;

import com.wasp.fidelity.church_secretaria_service.application.port.in.UpdateMemberUseCase;
import com.wasp.fidelity.church_secretaria_service.application.port.out.MemberRepository;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.exception.MemberNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateMemberService implements UpdateMemberUseCase {

    private final MemberRepository repository;

    public UpdateMemberService(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public Member execute(UUID id, Member updatedData) {
        Member existing = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));

        Member merged = existing.update(
                updatedData.getFullName(),
                updatedData.getEmail(),
                updatedData.getMobilePhone(),
                updatedData.getDateOfBirth(),
                updatedData.getBaptismDate(),
                updatedData.getStatus(),
                updatedData.getAddress()
        );
        return repository.save(merged);
    }

}
