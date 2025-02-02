package com.retobackend.api.runners;


import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/getEmployees.feature",
        glue = "com.retobackend.api.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@GetallEmployees"
)

public class GetEmployeesRunner {
}
