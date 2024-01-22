package com.choucar.web.tasks;

import com.choucar.web.userinterface.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.model.util.EnvironmentVariables;

import java.util.ArrayList;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectedProduct implements Task {
    EnvironmentVariables environmentVariables;
    private final String categoria;
    private final String subcategoria;



    public SelectedProduct(String categoria, String subcategoria) {
        this.categoria = categoria;
        this.subcategoria = subcategoria;
    }
    public static Performable withData(String categoria, String subcategoria) {
        return instrumented(SelectedProduct.class, categoria, subcategoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ProductPage.SELECT_SPAN_MENU, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(ProductPage.SELECT_SPAN_MENU));

        actor.attemptsTo(
                Click.on(ProductPage.BTN_CATEGORIES.of(categoria).called(categoria))
        );

        actor.attemptsTo(
                Click.on(ProductPage.BTN_SUB_CATEGORIES.of(subcategoria).called(subcategoria))
        );

    }

}
