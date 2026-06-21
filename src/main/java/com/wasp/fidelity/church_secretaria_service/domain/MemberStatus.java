package com.wasp.fidelity.church_secretaria_service.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MemberStatus {

    ACTIVE("Active"),
    INACTIVE("Inactive");

    /**
     * -- GETTER --
     *  Human-readable label.
     *  Suitable for UI display.
     */
    private final String displayName;

    MemberStatus(String displayName) {
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
    public static MemberStatus fromValue(String value) {

        if (value == null || value.isBlank()) {
            return null;
        }

        return Arrays.stream(values())
                .filter(status ->
                        status.name().equalsIgnoreCase(value)
                                || status.displayName.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Invalid member status: " + value));
    }
}
