package com.retobackend.api.interactions;


import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.model.util.*;

@Slf4j
public class GetRequest implements Interaction {

    private EnvironmentVariables environmentVariables;
    private static final String MESSAGE_OK = "service successfully consumed";
    private String baseUrl;
    private final String request;
    private final String typeContent;

    public GetRequest(String baseUrl, String request, String typeContent) {
        this.baseUrl = baseUrl;
        this.request = request;
        this.typeContent = typeContent;
    }
    @Override
    @Subject("{0} The user gets urlBase: #baseUrl - according to their environment: #typeContent, and they consume the #request service.")
    public <T extends Actor> void performAs(T actor) {
        String pathBaseUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(baseUrl);
        actor.whoCan(CallAnApi.at(pathBaseUrl));

        String cookie = "humans_21909=1";
        System.out.println("Cookie collected: " + cookie);

        actor.attemptsTo(
                Get.resource(request)
                        .with(requestSpecification -> requestSpecification
                                .accept(typeContent)
                                .relaxedHTTPSValidation()
                                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                                .header("Accept", "application/json, text/plain, */*")
                                .header("Connection", "keep-alive")
                                .cookie("humans_21909", cookie))
        );
        log.info(MESSAGE_OK);
        SerenityRest.lastResponse().body().prettyPrint();
    }
    public static GetRequest params(String baseUrl, String request, String typeContent){
        return Tasks.instrumented(GetRequest.class, baseUrl, request, typeContent);
    }
}
