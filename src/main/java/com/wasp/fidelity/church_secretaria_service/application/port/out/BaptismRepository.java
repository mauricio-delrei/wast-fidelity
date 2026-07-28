package com.wasp.fidelity.church_secretaria_service.application.port.out;

import java.util.UUID;

public interface BaptismRepository {

    boolean existsByMemberId(UUID memberId);
}
