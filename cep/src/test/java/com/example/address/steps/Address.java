package com.example.address.steps;

import com.devfelipeamorim.cep.controllers.AddressController;
import com.devfelipeamorim.cep.exceptions.AddressErrorException;
import com.devfelipeamorim.cep.models.Cep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Address {

    @Autowired
    private AddressController addressController;
    private ResponseEntity<?> response;
    private Cep cep;


    @Given("a valid Cep")
    public void givenValidCepVO() {
        cep = new Cep();
        cep.setCep("01001000");
    }

    @Given("an invalid Cep")
    public void givenInvalidCepVO() {
        cep = new Cep();
        cep.setCep("12345-678");
    }

    @When("the returnAddress function is called with the Cep")
    public void whenReturnAddressCalled() throws AddressErrorException {
        response = addressController.returnAddress(cep);
    }

    @Then("the response status should be HttpStatus.OK")
    public void thenResponseStatusShouldBeOK() {
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Then("the response status should be HttpStatus.NOT_FOUND")
    public void thenResponseStatusShouldBeNotFound() {
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}
