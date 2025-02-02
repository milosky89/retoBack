package com.retobackend.api.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/deleteEmployee.feature",
        glue = "com.retobackend.api.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@DeleteEmployee"
)
public class DeleteEmployeesRunner {
}
