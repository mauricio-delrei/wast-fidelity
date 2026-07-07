package com.wasp.fidelity.church_secretaria_service.application.port.in;

import com.wasp.fidelity.church_secretaria_service.domain.model.Member;

import java.util.List;

public interface GetAllMembersUseCase {

    List<Member> execute();
}
