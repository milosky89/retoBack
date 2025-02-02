package com.retobackend.api.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static com.retobackend.api.util.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class GetStatusCodeQuestion implements Question<Boolean> {

    private int statusOK;

    public GetStatusCodeQuestion(int statusOK) {
        this.statusOK = statusOK;
    }

    @Override
    @Subject("{0} validate status code successful #statusOK")
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse(STATUS,response -> response.statusCode(statusOK)));
        return true;
    }

    public static GetStatusCodeQuestion successful(int statusOK) {
        return new GetStatusCodeQuestion(statusOK);
    }
}
