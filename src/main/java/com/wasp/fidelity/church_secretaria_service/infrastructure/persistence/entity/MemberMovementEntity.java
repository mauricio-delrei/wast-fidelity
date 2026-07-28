package com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.entity;

import com.wasp.fidelity.church_secretaria_service.domain.enums.MemberMovementType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "member_movements")
@Getter
@NoArgsConstructor
public class MemberMovementEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(name = "member_id", nullable = false)
    private UUID memberId;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemberMovementType type;


    @Column(name = "movement_date", nullable = false)
    private LocalDateTime movementDate;


    @Column(length = 255)
    private String description;



    public MemberMovementEntity(
            UUID memberId,
            MemberMovementType type,
            LocalDateTime movementDate,
            String description
    ) {

        this.memberId = memberId;
        this.type = type;
        this.movementDate = movementDate;
        this.description = description;
    }
}
