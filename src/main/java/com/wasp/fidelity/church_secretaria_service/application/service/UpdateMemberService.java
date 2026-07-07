package com.wasp.fidelity.church_secretaria_service.application.service;

import com.wasp.fidelity.church_secretaria_service.application.port.in.UpdateMemberUseCase;
import com.wasp.fidelity.church_secretaria_service.application.port.out.MemberRepository;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.exception.MemberNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateMemberService implements UpdateMemberUseCase {

    private MemberRepository repository;

    public UpdateMemberService(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public Member execute(UUID id, Member updatedData) {
        Member existing = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));

        Member merged = merge(existing, updatedData);
        return repository.save(merged);
    }

    private Member merge(Member existing, Member updated) {

        return new Member.Builder()
                .id(existing.getId())
                .fullName(updated.getFullName() != null ? updated.getFullName() : existing.getFullName())
                .email(updated.getEmail() != null ? updated.getEmail() : existing.getEmail())
                .mobilePhone(updated.getMobilePhone() != null ? updated.getMobilePhone() : existing.getMobilePhone())
                .dateOfBirth(updated.getDateOfBirth() != null ? updated.getDateOfBirth() : existing.getDateOfBirth())
                .baptismDate(updated.getBaptismDate() != null ? updated.getBaptismDate() : existing.getBaptismDate())
                .status(updated.getStatus() != null ? updated.getStatus() : existing.getStatus())
                .address(updated.getAddress() != null ? updated.getAddress() : existing.getAddress())
                .build();
    }
}
