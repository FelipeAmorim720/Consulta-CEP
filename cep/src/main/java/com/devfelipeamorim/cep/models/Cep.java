package com.devfelipeamorim.cep.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import static com.devfelipeamorim.cep.utils.Constants.CEP_DESCRIPTION;
import static com.devfelipeamorim.cep.utils.Constants.CEP_EXAMPLE;

public class Cep {

    @NotNull
    @NotBlank
    @Size(min = 8, max = 9)
    @Schema(example = CEP_EXAMPLE, description = CEP_DESCRIPTION)
    public String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
