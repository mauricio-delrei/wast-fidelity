package com.wasp.fidelity.church_secretaria_service.application.port.out;

import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MemberRepository {


    Member save(Member member);


    Optional<Member> findById(UUID id);

    List<Member> findAll();

    boolean existsByEmail(String email);

    void delete(Member member);
}
