package com.wasp.fidelity.church_secretaria_service.presentation.dto.response;

public record FieldErrorResponse(
        String field,
        String message
) {
}
