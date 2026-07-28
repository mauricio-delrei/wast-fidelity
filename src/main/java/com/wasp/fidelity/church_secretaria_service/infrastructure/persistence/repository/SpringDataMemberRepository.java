package com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.repository;

import com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataMemberRepository extends JpaRepository<MemberEntity, UUID> {


    Optional<MemberEntity> findByMobilePhone(String mobilePhone);
    Optional<MemberEntity> findByEmail(String email);
}
