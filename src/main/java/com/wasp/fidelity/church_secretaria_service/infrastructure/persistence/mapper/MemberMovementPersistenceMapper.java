package com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.mapper;

import com.wasp.fidelity.church_secretaria_service.domain.model.MemberMovement;
import com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.entity.MemberMovementEntity;
import org.springframework.stereotype.Component;


@Component
public class MemberMovementPersistenceMapper {


    public MemberMovementEntity toEntity(MemberMovement movement) {

        return new MemberMovementEntity(
                movement.getMemberId(),
                movement.getType(),
                movement.getMovementDate(),
                movement.getDescription()
        );
    }
}
