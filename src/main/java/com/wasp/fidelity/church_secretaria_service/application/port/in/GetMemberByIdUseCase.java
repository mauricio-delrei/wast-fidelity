package com.wasp.fidelity.church_secretaria_service.application.port.in;

import com.wasp.fidelity.church_secretaria_service.domain.model.Member;

import java.util.UUID;

public interface GetMemberByIdUseCase {
    Member execute(UUID id);
}
