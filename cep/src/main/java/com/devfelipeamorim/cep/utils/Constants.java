package com.devfelipeamorim.cep.utils;

public class Constants {
    public static final double SUDESTE = 7.85;
    public static final double CENTRO_OESTE = 12.50;
    public static final double NORDESTE = 15.98;
    public static final double SUL = 17.30;
    public static final double NORTE = 20.83;

    public static final String TAG_NAME = "Controller Endereço via CEP";
    public static final String TAG_DESCRIPTION = "Controller para gerenciamento dos métodos";

    public static final String OPERATION_SUMMARY = "Obter informações via CEP";
    public static final String OPERATION_DESCRIPTION = "<b> Consulta de endereço e cálculo de frete. </b>";

    public static final String CEP_NOT_FOUND = "CEP não encontrado";
    public static final String CEP_ERROR = "Erro ao buscar endereço por CEP";

    public static final String NOT_FOUND_EXCEPTION_DESCRIPTION = "Exceção para representar erro de CEP não encontrado";

    public static final String CEP_EXAMPLE = "01414-000";
    public static final String CEP_DESCRIPTION = "CEP";
    public static final String LOGRADOURO = "logradouro";
    public static final String STREET_EXAMPLE = "Haddock Lobo";
    public static final String STREET_DESCRIPTION = "Nome da rua";
    public static final String COMPLEMENT_EXAMPLE = "até 1048 - lado par";
    public static final String COMPLEMENT_DESCRIPTION = "Complemento";
    public static final String DISTRICT_EXAMPLE = "Cerqueira César";
    public static final String DISTRICT_DESCRIPTION = "Bairro";
    public static final String LOCALIDADE = "localidade";
    public static final String CITY_EXAMPLE = "São Paulo";
    public static final String CITY_DESCRIPTION = "Cidade";
    public static final String UF = "uf";
    public static final String STATE_EXAMPLE = "SP";
    public static final String STATE_DESCRIPTION = "Estado";
    public static final String FRETE_EXAMPLE = "7.85";
    public static final String FRETE_DESCRIPTION = "Frete";

    public static final String HOST_API = "https://viacep.com.br/ws/";
    public static final String PARAMETER_API = "/json/";

    public static final String SUCCESS_FALSE = "false";

    public static final String CEP_FORMAT = "CEP inválido: o CEP com 9 caracteres deve seguir o formato '12345-678'.";
    public static final String CEP_CARACTER = "CEP inválido: o CEP com 8 caracteres não pode conter traço.";
}
