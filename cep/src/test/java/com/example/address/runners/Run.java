package com.example.address.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberOptions(
        features = {"src/test/java/com/example/address/features"},
        glue = {"com.example.address.steps", "com.example.address.configurations"},
        monochrome = true
)
@SpringBootTest
public class Run extends AbstractTestNGCucumberTests {

}
