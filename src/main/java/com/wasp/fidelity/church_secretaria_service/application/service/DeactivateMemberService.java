package com.wasp.fidelity.church_secretaria_service.application.service;

import com.wasp.fidelity.church_secretaria_service.application.port.in.DeactivateMemberUseCase;
import com.wasp.fidelity.church_secretaria_service.application.port.out.MemberRepository;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.exception.MemberNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeactivateMemberService implements DeactivateMemberUseCase {

    private final MemberRepository repository;

    public DeactivateMemberService(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Member execute(UUID id) {


        Member member = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));


        Member deactivatedMember = member.deactivate();


        return repository.save(deactivatedMember);

    }
}
