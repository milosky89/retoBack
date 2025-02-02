package com.retobackend.api.tasks.getEmployee;

import com.retobackend.api.interactions.GetRequest;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class ConsumeServiceGet {

    public Performable apiGet(String baseUrl, String request, String typeContent) {
        return Task.where("{0} call the service at execute GET",
                GetRequest.params(baseUrl, request, typeContent)
        );
    }
}
