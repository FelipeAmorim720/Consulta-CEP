package com.devfelipeamorim.address.configurations;

import com.devfelipeamorim.cep.CepApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = CepApplication.class)
public class CucumberSpringConfiguration {
}
