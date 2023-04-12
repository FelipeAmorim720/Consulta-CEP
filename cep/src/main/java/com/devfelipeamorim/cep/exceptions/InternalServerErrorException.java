package com.devfelipeamorim.cep.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;

import static com.devfelipeamorim.cep.utils.Constants.*;

@Schema(description = INTERNAL_EXCEPTION_DESCRIPTION)
public class InternalServerErrorException {

    @Schema(example = SUCCESS_FALSE)
    private Boolean success;

    @Schema(example = CEP_ERROR)
    private String message;

    public InternalServerErrorException(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
