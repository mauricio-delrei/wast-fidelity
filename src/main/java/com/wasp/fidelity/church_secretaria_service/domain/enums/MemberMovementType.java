package com.wasp.fidelity.church_secretaria_service.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MemberMovementType {

    BAPTISM("Baptism"),
    TRANSFER_IN("Transfer In"),
    TRANSFER_OUT("Transfer Out"),
    ACTIVATION("Activation"),
    DEACTIVATION("Deactivation");

    /**
     * Human-readable label.
     * Suitable for UI display.
     */
    private final String displayName;


    MemberMovementType(String displayName) {
        this.displayName = displayName;
    }


    /**
     * Value exposed in JSON.
     */
    @JsonValue
    public String getValue() {
        return name();
    }


    /**
     * Accepts enum name or display name.
     */
    @JsonCreator
    public static MemberMovementType fromValue(String value) {

        if (value == null || value.isBlank()) {
            return null;
        }

        return Arrays.stream(values())
                .filter(type ->
                        type.name().equalsIgnoreCase(value)
                                || type.displayName.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Invalid member movement type: " + value));
    }
}
