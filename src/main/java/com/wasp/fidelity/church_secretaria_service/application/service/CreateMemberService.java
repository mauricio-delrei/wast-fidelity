package com.wasp.fidelity.church_secretaria_service.application.service;

import com.wasp.fidelity.church_secretaria_service.application.port.in.CreateMemberUseCase;
import com.wasp.fidelity.church_secretaria_service.application.port.out.MemberRepository;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.exception.BusinessRuleException;
import com.wasp.fidelity.church_secretaria_service.exception.EmailAlreadyExistsException;
import com.wasp.fidelity.church_secretaria_service.exception.PhoneAlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
public class CreateMemberService implements CreateMemberUseCase {

    private final MemberRepository repository;

    public CreateMemberService(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public Member execute(Member member) {

        validateEmailUniqueness(member);
        validateMobilePhoneUniqueness(member);

        return repository.save(member);
    }

    private void validateEmailUniqueness(Member member) {

        repository.findByEmail(member.getEmail())
                .ifPresent(existing -> {
                    throw new EmailAlreadyExistsException(
                            member.getEmail()
                    );
                });
    }

    private void validateMobilePhoneUniqueness(Member member) {

        repository.findByMobilePhone(member.getMobilePhone())
                .ifPresent(existing -> {
                    throw new PhoneAlreadyExistsException(
                            member.getMobilePhone()
                    );
                });
    }
}