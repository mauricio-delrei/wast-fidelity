package com.wasp.fidelity.church_secretaria_service.application.port.in;

import com.wasp.fidelity.church_secretaria_service.domain.model.Member;

public interface CreateMemberUseCase {
    Member execute(Member member);
}
