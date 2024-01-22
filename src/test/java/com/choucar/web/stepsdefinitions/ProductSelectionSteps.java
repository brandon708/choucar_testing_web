package com.choucar.web.stepsdefinitions;

import com.choucar.web.tasks.OpenUrl;
import com.choucar.web.tasks.SelectedProduct;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ProductSelectionSteps {
    @Before
    public void setTheStage() {

        OnStage.setTheStage(new OnlineCast());
    }
    @When("^selecciono la categoría (.*) y la subcategoría (.*)$")
    public void seleccionoLaCategoriaYLaSubcategoria(String categoria, String subcategoria) {
       theActorInTheSpotlight().attemptsTo(SelectedProduct.withData(categoria,subcategoria));
    }
}
