package com.devfelipeamorim.address.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberOptions(
        features = {"src/test/java/com/devfelipeamorim/address/features"},
        glue = {"com.devfelipeamorim.address.steps", "com.devfelipeamorim.address.configurations"},
        monochrome = true
)
@SpringBootTest
public class Run extends AbstractTestNGCucumberTests {

}
