package com.retobackend.api.stepdefinitions;

import com.retobackend.api.questions.GetStatusCodeQuestion;
import com.retobackend.api.questions.GetLastResponse;
import com.retobackend.api.tasks.getEmployee.Call;
import com.retobackend.api.util.Uri;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static com.retobackend.api.util.Constants.*;
import static io.restassured.parsing.Parser.JSON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;

public class GetEmployeesStepdefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("I get all employees")
    public void iGetAllEmployees() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                Call.service().apiGet(BASE_URL.replace(TYPE_ENVIRONMENT,ENV_QA),
                        Uri.GET_ALL_EMPLOYEE.getUri(),
                        String.valueOf(JSON))
        );
    }

    @When("I get employee by id {string}")
    public void iGetEmployeesById(String id) {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                Call.service().apiGet(BASE_URL.replace(TYPE_ENVIRONMENT,ENV_QA),
                        Uri.GET_EMPLOYEE_ID.withId(id),
                        String.valueOf(JSON))
        );
    }
    @Then("I see the response code {int}")
    public void iSeeTheResponseCode(Integer code) {
        theActorInTheSpotlight().should(seeThat(GetStatusCodeQuestion.successful(code)));
    }
    @Then("I body of the response is not empty")
    public void iBodyOfTheResponseIsNotEmpty() {
        theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(),containsString("id")));
    }

}
