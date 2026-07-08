package com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.repository;

import com.wasp.fidelity.church_secretaria_service.application.port.out.MemberRepository;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.mapper.MemberPersistenceMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final SpringDataMemberRepository jpaRepository;
    private final MemberPersistenceMapper mapper;

    public MemberRepositoryImpl(SpringDataMemberRepository jpaRepository,
                                MemberPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Member save(Member member) {
        System.out.println("STATUS: " + member.getStatus());
        System.out.println("DEACTIVATED AT: " + member.getDeactivatedAt());
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(member))

        );
    }


    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }

    @Override
    public Optional<Member> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Member> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
