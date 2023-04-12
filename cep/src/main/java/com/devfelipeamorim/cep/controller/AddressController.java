package com.devfelipeamorim.cep.controller;

import com.devfelipeamorim.cep.exceptions.AddressErrorException;
import com.devfelipeamorim.cep.exceptions.InternalServerErrorException;
import com.devfelipeamorim.cep.exceptions.NotFoundException;
import com.devfelipeamorim.cep.model.Address;
import com.devfelipeamorim.cep.service.AddressService;
import com.devfelipeamorim.cep.vo.CepVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.devfelipeamorim.cep.utils.Constants.*;

@RestController
@RequestMapping("/v1")
@Tag(name = TAG_NAME, description = TAG_DESCRIPTION)
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.ALL_VALUE, schema = @Schema(implementation = Address.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = MediaType.ALL_VALUE, schema = @Schema(implementation = NotFoundException.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = MediaType.ALL_VALUE, schema = @Schema(implementation = InternalServerErrorException.class)))})
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = OPERATION_SUMMARY, description = OPERATION_DESCRIPTION)
    @PostMapping("/consulta-endereco")
    public ResponseEntity returnAddress(@Valid @RequestBody CepVO cep) throws AddressErrorException {
        return addressService.searchAddressByCep(cep);
    }

}

