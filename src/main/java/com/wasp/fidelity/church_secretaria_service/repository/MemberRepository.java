package com.wasp.fidelity.church_secretaria_service.repository;

import com.wasp.fidelity.church_secretaria_service.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
