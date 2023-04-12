package com.devfelipeamorim.cep.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import static com.devfelipeamorim.cep.utils.Constants.*;

public class Address {

    @Schema(example = CEP_EXAMPLE, description = CEP_DESCRIPTION)
    private String cep;

    @SerializedName(LOGRADOURO)
    @Schema(example = STREET_EXAMPLE, description = STREET_DESCRIPTION)
    private String rua;

    @Schema(example = COMPLEMENT_EXAMPLE, description = COMPLEMENT_DESCRIPTION)
    private String complemento;

    @Schema(example = DISTRICT_EXAMPLE, description = DISTRICT_DESCRIPTION)
    private String bairro;

    @SerializedName(LOCALIDADE)
    @Schema(example = CITY_EXAMPLE, description = CITY_DESCRIPTION)
    private String cidade;

    @SerializedName(UF)
    @Schema(example = STATE_EXAMPLE, description = STATE_DESCRIPTION)
    private String estado;

    @Schema(example = FRETE_EXAMPLE, description = FRETE_DESCRIPTION)
    private double frete;

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }
}
