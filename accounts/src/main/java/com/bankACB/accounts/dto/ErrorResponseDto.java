package com.bankACB.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(name = "ErrorResponseDto", description = "Details about an error response")
public class ErrorResponseDto {

    @Schema(description = "API path where the error occurred", example = "/api/fetch")
    private String apiPath;

    @Schema(description = "HTTP status code of the error", example = "500")
    private HttpStatus errorCode;

    @Schema(description = "Detailed message explaining the error", example = "Internal Server Error")
    private String errorMessage;

    @Schema(description = "Timestamp when the error occurred", example = "2025-09-03T06:35:00")
    private LocalDateTime errorTime;
}
