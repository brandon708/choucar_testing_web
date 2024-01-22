package com.choucar.web.stepsdefinitions;

import com.choucar.web.questions.ExitoQuestions;
import com.choucar.web.questions.ValidacionQuestions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static org.hamcrest.CoreMatchers.equalTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ValidateSteps {
    @Before
    public void setTheStage() {

        OnStage.setTheStage(new OnlineCast());
    }
    
    @And("valido el nombre de los productos del carrito que deben ser iguales a los productos seleccionados")
    public void validoElNombreDeLosProductosDelCarritoQueDebenSerIgualesALosProductosSeleccionados() {
        String[] nameProductos = Serenity.sessionVariableCalled("nameProductos");

        theActorInTheSpotlight().should(
                seeThat(ValidacionQuestions.nombreProductos(nameProductos), equalTo(true)));
    }


    @And("valido el total de los precios de los productos agregados deberá ser igual que en el carrito")
    public void validoElTotalDeLosPreciosDeLosProductosAgregadosDeberáSerIgualQueEnElCarrito() {

        String[] nameProductos = Serenity.sessionVariableCalled("nameProductos");
        String[] precioProductosTotal = Serenity.sessionVariableCalled("precioProductosTotal");

        theActorInTheSpotlight().should(
                seeThat(ValidacionQuestions.precioProductos(nameProductos,precioProductosTotal), equalTo(true)));
    }

    @And("valido las cantidades de los productos agregados deberá ser igual que en el carrito")
    public void validoLasCantidadesDeLosProductosAgregadosDeberáSerIgualQueEnElCarrito() {

      String[] nameProductos = Serenity.sessionVariableCalled("nameProductos");
      int[] numProductsAdd = Serenity.sessionVariableCalled("numProductsAdd");
      String[] cantProductosAgregados = new String[numProductsAdd.length];
        for(int i = 0; i<nameProductos.length;i++){
        cantProductosAgregados[i] = String.valueOf(numProductsAdd[i]+1);
      }

        theActorInTheSpotlight().should(
                seeThat(ValidacionQuestions.cantProductos(nameProductos,cantProductosAgregados), equalTo(true)));
    }

    @Then("valido el número de productos agregados debe ser igual que en el carrito")
    public void validoElNúmeroDeProductosAgregadosDebeSerIgualQueEnElCarrito() {

        int cantProducts = Serenity.sessionVariableCalled("cantProducts");

        theActorInTheSpotlight().should(
                seeThat(ValidacionQuestions.cantiProductosCarrito(cantProducts), equalTo(true)));
    }
}
