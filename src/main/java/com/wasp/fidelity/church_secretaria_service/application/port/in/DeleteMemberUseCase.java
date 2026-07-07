package com.wasp.fidelity.church_secretaria_service.application.port.in;

import java.util.UUID;

public interface DeleteMemberUseCase {
    void execute(UUID id);
}
