package com.wasp.fidelity.church_secretaria_service.application.port.in;

import com.wasp.fidelity.church_secretaria_service.application.command.RegisterBaptizedMemberCommand;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;

public interface RegisterBaptizedMemberUseCase {

    Member execute(RegisterBaptizedMemberCommand command);
}
