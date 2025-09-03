package com.bankACB.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "ResponseDto", description = "Response details with status code and message")
public class ResponseDto {

    @Schema(description = "Status code of the response", example = "200")
    private String statusCode;

    @Schema(description = "Status message describing the response", example = "Operation successful")
    private String statusMsg;
}
