package com.wasp.fidelity.church_secretaria_service.presentation.dto.response;

import java.util.List;

public record ValidationErrorResponse(
        String message,
        List<FieldErrorResponse> errors
) {
}

