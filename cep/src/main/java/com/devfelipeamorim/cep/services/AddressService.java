package com.devfelipeamorim.cep.services;

import com.devfelipeamorim.cep.enums.Region;
import com.devfelipeamorim.cep.exceptions.AddressErrorException;
import com.devfelipeamorim.cep.exceptions.NotFoundException;
import com.devfelipeamorim.cep.models.Address;
import com.devfelipeamorim.cep.models.Cep;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import static com.devfelipeamorim.cep.utils.Constants.*;
import static com.devfelipeamorim.cep.utils.FreteUtils.freteMap;

@Service
public class AddressService {

    @Autowired
    private RestTemplate restTemplate;

    Gson gson = new Gson();

    public ResponseEntity searchAddressByCep(Cep cep) throws AddressErrorException {
        validateCep(cep);
        ResponseEntity<String> responseEntity = callExternalApi(cep);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            Address address = gson.fromJson(responseEntity.getBody(), Address.class);

            try {

                if (address != null && address.getEstado() != null) {
                    String estado = address.getEstado();
                    Region region = Region.valueOf(estado);

                    if (freteMap.containsKey(region)) {
                        Double freteAtualizado = freteMap.getOrDefault(region, 0.0);
                        if (freteAtualizado != null) {
                            address.setFrete(freteAtualizado);
                        }
                    }

                    return ResponseEntity.ok(address);
                } else {
                    NotFoundException notFoundException = new NotFoundException(false, CEP_NOT_FOUND);
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundException);
                }

            } catch (Exception e) {
                throw new AddressErrorException(CEP_ERROR, e);
            }
        } else {
            return ResponseEntity.status(responseEntity.getStatusCode()).body(CEP_ERROR);
        }
    }

    private ResponseEntity callExternalApi(Cep cep) throws AddressErrorException {
        String url = HOST_API + cep.getCep() + PARAMETER_API;

        try {
            return restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        } catch (HttpServerErrorException e) {
            throw new AddressErrorException(CEP_ERROR, e);
        }
    }

    public void validateCep(Cep cep) throws AddressErrorException {
        String cepValue = cep.getCep();

        // Cep com 8 caracteres não deve ter traço
        if (cepValue.length() == 8 && cepValue.contains("-")) {
            throw new AddressErrorException(CEP_CARACTER);
        } else if (cepValue.length() == 9) {
            // Cep com 9 caracteres deve ter traço na sexta posição
            if (!cepValue.matches("\\d{5}-\\d{3}")) {
                throw new AddressErrorException(CEP_FORMAT);
            }
        }
    }

}