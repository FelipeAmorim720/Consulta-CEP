package com.devfelipeamorim.cep.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;

import static com.devfelipeamorim.cep.utils.Constants.*;

@Schema(description = NOT_FOUND_EXCEPTION_DESCRIPTION)
public class NotFoundException {

    @Schema(example = SUCCESS_FALSE)
    private Boolean success;

    @Schema(example = CEP_NOT_FOUND)
    private String message;

    public NotFoundException(Boolean success, String message) {
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
