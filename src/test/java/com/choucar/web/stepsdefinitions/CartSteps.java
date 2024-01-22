package com.choucar.web.stepsdefinitions;

import com.choucar.web.tasks.SelectRandom;
import com.choucar.web.tasks.SelectedCart;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CartSteps {
    @Before
    public void setTheStage() {

        OnStage.setTheStage(new OnlineCast());
    }

    @And("^añado (.*) productos aleatorios con cantidades entre (.*) y (.*) al carrito$")
    public void añadoProductosAleatoriosConCantidadesEntreYAlCarrito(int cantProducts, int rangoInicial, int rangoFinal) {
        theActorInTheSpotlight().attemptsTo(SelectRandom.withData(cantProducts, rangoInicial, rangoFinal));
        theActorInTheSpotlight().attemptsTo(new SelectedCart());
    }



}
