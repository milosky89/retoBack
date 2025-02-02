package com.retobackend.api.stepdefinitions;


import com.retobackend.api.questions.GetLastResponse;
import com.retobackend.api.tasks.deleteEmployee.Call;
import com.retobackend.api.util.Uri;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static com.retobackend.api.util.Constants.*;
import static io.restassured.parsing.Parser.JSON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.allOf;

public class DeleteEmployeeStepdefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("delete employee by id {string}")
    public void deleteEmployeeById(String id) {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                Call.service().apiDelete(BASE_URL.replace(TYPE_ENVIRONMENT,ENV_QA),
                        Uri.DELETE_EMPLOYEE.withId(id),
                        String.valueOf(JSON))
        );
    }
    @Then("I validate the response message is correct {string}")
    public void iValidateTheResponseMenssge(String message) {
        theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), allOf(
                Matchers.containsString(message)
        )));
    }

}
