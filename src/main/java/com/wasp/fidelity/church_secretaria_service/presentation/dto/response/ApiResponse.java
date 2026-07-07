package com.wasp.fidelity.church_secretaria_service.presentation.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    private final int status;
    private final String message;
    private final T data;
    private final LocalDateTime timestamp;

    public ApiResponse(int status, String message,T data){
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

}
