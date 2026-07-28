package com.wasp.fidelity.church_secretaria_service.application.port.out;

import com.wasp.fidelity.church_secretaria_service.domain.enums.MemberMovementType;
import com.wasp.fidelity.church_secretaria_service.domain.model.MemberMovement;

import java.util.UUID;

public interface MemberMovementRepository {

    MemberMovement save(MemberMovement movement);
    boolean existsByMemberIdAndType(
            UUID memberId,
            MemberMovementType type
    );
}
