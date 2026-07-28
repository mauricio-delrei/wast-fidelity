package com.wasp.fidelity.church_secretaria_service.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private int status;

    private String error;

    private String message;

    private LocalDateTime timestamp;

    private String path;
}
