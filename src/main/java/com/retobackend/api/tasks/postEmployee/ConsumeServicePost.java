package com.retobackend.api.tasks.postEmployee;

import com.retobackend.api.interactions.PostRequest;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class ConsumeServicePost {

    public Performable apiPost(String baseUrl, String bodyRequest, String request, String typeContent){
        return Task.where("{0} call the service at execute POST",
                PostRequest.params(baseUrl,bodyRequest,request,typeContent));
    }
}
