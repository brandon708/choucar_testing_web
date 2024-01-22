package com.choucar.web.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenUrl implements Task {
    private final String url;
    EnvironmentVariables environmentVariables;

    public OpenUrl(String url) {
        this.url = url;
    }

    public static Task exito() {
        String url = "exito.url";
        return instrumented(OpenUrl.class, url);
    }

    @Override
    @Step("{0} Inicia la página #url")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.url(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(url)));
    }

}
