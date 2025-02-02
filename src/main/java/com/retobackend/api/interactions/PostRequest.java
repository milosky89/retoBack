package com.retobackend.api.interactions;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.model.util.EnvironmentVariables;

@Slf4j
public class PostRequest implements Interaction {
    private EnvironmentVariables environmentVariables;
    private static final String MESSAGE_OK = "service successfully consumed";
    private String baseUrl;
    private String body;
    private final String requestUri;
    private final String typeContent;

    public PostRequest(String baseUrl, String body, String requestUri, String typeContent) {
        this.baseUrl = baseUrl;
        this.body = body;
        this.requestUri = requestUri;
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
                Post.to(requestUri)
                        .with(request -> request
                                .contentType(typeContent)
                                .body(body)
                                .relaxedHTTPSValidation()
                                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                                .header("Accept", "application/json, text/plain, */*")
                                .header("Connection", "keep-alive")
                                .cookie("humans_21909", cookie)
                        )
        );
        log.info(MESSAGE_OK);
        SerenityRest.lastResponse().body().prettyPrint();
    }
    public static PostRequest params(String baseUrl, String bodyRequest, String requestUri, String typeContent){
        return Tasks.instrumented(PostRequest.class, baseUrl,bodyRequest,requestUri,typeContent);
    }
}
