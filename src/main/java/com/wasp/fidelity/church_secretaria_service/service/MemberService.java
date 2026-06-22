package com.wasp.fidelity.church_secretaria_service.service;

import com.wasp.fidelity.church_secretaria_service.domain.Member;
import com.wasp.fidelity.church_secretaria_service.domain.dto.request.MemberRequest;
import com.wasp.fidelity.church_secretaria_service.domain.dto.response.MemberResponse;
import com.wasp.fidelity.church_secretaria_service.mapper.MemberMapper;
import com.wasp.fidelity.church_secretaria_service.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public MemberResponse create(MemberRequest request) {
        Member member = MemberMapper.toEntity(request);
        Member saved = repository.save(member);
        return MemberMapper.toResponse(saved);
    }

    public List<MemberResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(MemberMapper::toResponse)
                .toList();
    }
}