package com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.repository;

import com.wasp.fidelity.church_secretaria_service.domain.enums.MemberMovementType;
import com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.entity.MemberMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataMemberMovementRepository
        extends JpaRepository<MemberMovementEntity, UUID> {

    boolean existsByMemberIdAndType(
            UUID memberId,
            MemberMovementType type
    );
}
