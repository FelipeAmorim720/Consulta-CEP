package com.devfelipeamorim.cep.service;

import com.devfelipeamorim.cep.enums.Region;
import com.devfelipeamorim.cep.exceptions.AddressErrorException;
import com.devfelipeamorim.cep.exceptions.NotFoundException;
import com.devfelipeamorim.cep.model.Address;
import com.devfelipeamorim.cep.vo.CepVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.devfelipeamorim.cep.utils.Constants.*;
import static com.devfelipeamorim.cep.utils.FreteUtils.freteMap;

@Service
public class AddressService {

    @Autowired
    private RestTemplate restTemplate;

    Gson gson = new Gson();

    public ResponseEntity searchAddressByCep(CepVO cep) throws AddressErrorException {

        String url = HOST_API + cep.getCep() + PARAMETER_API;
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class, cep);

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

}