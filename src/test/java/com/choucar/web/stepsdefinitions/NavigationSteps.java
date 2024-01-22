package com.choucar.web.stepsdefinitions;

import com.choucar.web.tasks.OpenUrl;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class NavigationSteps {
    @Before
    public void setTheStage() {

        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^que soy un (usuario) en el sitio web de Tiendas Éxito$")
    public void ingresoUrl(String user) {
        theActorCalled(user).attemptsTo(OpenUrl.exito());
    }
}
