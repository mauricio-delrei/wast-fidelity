package com.wasp.fidelity.church_secretaria_service.application.service;

import com.wasp.fidelity.church_secretaria_service.application.port.in.GetAllMembersUseCase;
import com.wasp.fidelity.church_secretaria_service.application.port.out.MemberRepository;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllMembersService implements GetAllMembersUseCase {

    private final MemberRepository repository;

    public GetAllMembersService(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Member> execute() {
        return repository.findAll() ;
    }
}
