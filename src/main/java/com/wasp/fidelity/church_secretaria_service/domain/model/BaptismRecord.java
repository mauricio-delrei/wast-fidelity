package com.wasp.fidelity.church_secretaria_service.domain.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class BaptismRecord {

    private final UUID id;

    private final UUID memberId;

    private final LocalDate baptismDate;

    private final String churchName;

    private final boolean currentChurch;


    public BaptismRecord(
            UUID id,
            UUID memberId,
            LocalDate baptismDate,
            String churchName,
            boolean currentChurch
    ) {
        this.id = id;
        this.memberId = memberId;
        this.baptismDate = baptismDate;
        this.churchName = churchName;
        this.currentChurch = currentChurch;
    }
}
