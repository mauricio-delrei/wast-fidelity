package com.wasp.fidelity.church_secretaria_service.application.port.in;

import com.wasp.fidelity.church_secretaria_service.domain.model.Member;

import java.util.UUID;

public interface DeactivateMemberUseCase {
    Member execute(UUID id);
}
