package com.wasp.fidelity.church_secretaria_service.domain.model;

import com.wasp.fidelity.church_secretaria_service.domain.enums.MemberMovementType;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class MemberMovement {

    private final UUID id;

    private final UUID memberId;

    private final MemberMovementType type;

    private final LocalDateTime movementDate;

    private final String description;


    private MemberMovement(
            UUID id,
            UUID memberId,
            MemberMovementType type,
            LocalDateTime movementDate,
            String description
    ) {
        this.id = id;
        this.memberId = memberId;
        this.type = type;
        this.movementDate = movementDate;
        this.description = description;
    }


    public static MemberMovement baptism(UUID memberId) {

        return new MemberMovement(
                UUID.randomUUID(),
                memberId,
                MemberMovementType.BAPTISM,
                LocalDateTime.now(),
                "Member baptized"
        );
    }
}
