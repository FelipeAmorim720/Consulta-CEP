import com.devfelipeamorim.cep.controller.AddressController;
import com.devfelipeamorim.cep.exceptions.AddressErrorException;
import com.devfelipeamorim.cep.service.AddressService;
import com.devfelipeamorim.cep.vo.CepVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressControllerTest {

    @InjectMocks
    private AddressController addressController;

    @Mock
    private AddressService addressService;

    @Test
    @DisplayName("Testing return of address with valid CEP")
    public void testReturnAddressWithValidCep() throws AddressErrorException {
        // Dado um CepVO válido
        CepVO cep = new CepVO();
        cep.setCep("01001000");

        // Configuração do comportamento do AddressService mock
        when(addressService.searchAddressByCep(cep)).thenReturn(ResponseEntity.ok().build());

        // Quando chamar a função returnAddress do AddressController
        ResponseEntity response = addressController.returnAddress(cep);

        // Então o status da resposta deve ser HttpStatus.OK
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("Testing return of address with invalid CEP")
    public void testReturnAddressWithNotFoundCep() throws AddressErrorException {
        // Dado um CepVO inválido
        CepVO cep = new CepVO();
        cep.setCep("12345-678");

        // Configuração do comportamento do AddressService mock
        when(addressService.searchAddressByCep(cep)).thenReturn(ResponseEntity.notFound().build());

        // Quando chamar a função returnAddress do AddressController
        ResponseEntity response = addressController.returnAddress(cep);

        // Então o status da resposta deve ser HttpStatus.NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @DisplayName("Testing return of address with Internal Server Error")
    public void testReturnAddressWithInternalServerError() throws AddressErrorException {
        // Dado um CepVO qualquer
        CepVO cep = new CepVO();
        cep.setCep("08320810");

        // Configuração do comportamento do AddressService mock para retornar HttpStatus.INTERNAL_SERVER_ERROR
        when(addressService.searchAddressByCep(cep)).thenReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());

        // Quando chamar a função returnAddress do AddressController
        ResponseEntity response = addressController.returnAddress(cep);

        // Então o status da resposta deve ser HttpStatus.INTERNAL_SERVER_ERROR
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

}
