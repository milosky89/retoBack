package com.retobackend.api.stepdefinitions;

import com.retobackend.api.models.Employee;
import com.retobackend.api.questions.GetLastResponse;
import com.retobackend.api.tasks.postEmployee.Call;
import com.retobackend.api.util.Generate;
import com.retobackend.api.util.JsonUtil;
import com.retobackend.api.util.Uri;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.retobackend.api.util.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;


public class CreateEmployeeStepdefinition {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("create an employee")
    public void createAnEmployee() {
        Employee employee = Generate.generateEmployee();
        String body = JsonUtil.convertToJson(employee);
        OnStage.theActorCalled(ACTOR).remember("employee", employee);
        OnStage.theActorCalled(ACTOR).attemptsTo(
                Call.services().apiPost(BASE_URL.replace(TYPE_ENVIRONMENT,ENV_QA),
                        body,
                        Uri.CREATE_EMPLOYEE.getUri(),
                        "application/json")
        );
    }


    @Then("I see employee data")
    public void iSeeEmployeeData() {
        Employee employee = theActorInTheSpotlight().recall("employee");
        theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), allOf(
                containsString(employee.getName()),
                containsString(employee.getAge()),
                containsString(employee.getSalary())
        )));
    }
}
