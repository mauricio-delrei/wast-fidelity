package com.wasp.fidelity.church_secretaria_service.service;

import com.wasp.fidelity.church_secretaria_service.domain.entity.Member;
import com.wasp.fidelity.church_secretaria_service.domain.dto.request.MemberRequest;
import com.wasp.fidelity.church_secretaria_service.domain.dto.response.MemberResponse;
import com.wasp.fidelity.church_secretaria_service.domain.entity.Address;
import com.wasp.fidelity.church_secretaria_service.exception.MemberNotFoundException;
import com.wasp.fidelity.church_secretaria_service.mapper.AddressMapper;
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

    // CREATE
    public MemberResponse create(MemberRequest request) {
        Address address = AddressMapper.toEntity(request.address());
        Member member = MemberMapper.toEntity(request);
        member.setAddress(address);
        return MemberMapper.toResponse(repository.save(member));
    }

    // READ ALL
    public List<MemberResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(MemberMapper::toResponse)
                .toList();
    }

    // READ BY ID
    public MemberResponse findById(Long id) {
        Member member = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));

        return MemberMapper.toResponse(member);
    }

    // UPDATE
    public MemberResponse update(Long id, MemberRequest request) {

        Member existing = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));

        Member updated = MemberMapper.toEntity(request);
        updated.setId(existing.getId());

        return MemberMapper.toResponse(repository.save(updated));
    }

    // DELETE
    public void delete(Long id) {

        Member existing = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));

        repository.delete(existing);
    }
}