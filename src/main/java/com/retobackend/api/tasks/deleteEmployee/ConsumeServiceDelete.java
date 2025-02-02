package com.retobackend.api.tasks.deleteEmployee;

import com.retobackend.api.interactions.DeleteRequest;
import com.retobackend.api.interactions.GetRequest;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class ConsumeServiceDelete {

    public Performable apiDelete(String baseUrl, String request, String typeContent){
        return Task.where("{0} call the service at execute DELETE",
                DeleteRequest.params(baseUrl, request, typeContent)
        );
    }
}
