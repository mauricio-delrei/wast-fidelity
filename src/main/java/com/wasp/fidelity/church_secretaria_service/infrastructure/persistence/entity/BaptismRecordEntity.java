package com.wasp.fidelity.church_secretaria_service.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "baptism_records")
@Getter
@NoArgsConstructor
public class BaptismRecordEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(nullable = false)
    private UUID memberId;


    @Column(nullable = false)
    private LocalDate baptismDate;


    @Column(nullable = false)
    private String churchName;


    @Column(nullable = false)
    private boolean currentChurch;
}
