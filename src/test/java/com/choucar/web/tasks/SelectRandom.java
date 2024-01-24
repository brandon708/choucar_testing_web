package com.choucar.web.tasks;

import com.choucar.web.questions.ExitoQuestions;
import com.choucar.web.userinterface.ProductPage;
import com.choucar.web.util.CommonUtil;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectRandom implements Task {
    private final int cantProducts;
    private final int rangoInicial;
    private final int rangoFinal;

    public SelectRandom(int cantProducts, int rangoInicial, int rangoFinal) {
        this.cantProducts = cantProducts;
        this.rangoInicial = rangoInicial;
        this.rangoFinal = rangoFinal;
    }

    public static Performable withData(int cantProducts, int rangoInicial, int rangoFinal) {
        return instrumented(SelectRandom.class, cantProducts, rangoInicial, rangoFinal);
    }

    private void handleModal(Actor actor) {
        if (ProductPage.MODAL.isVisibleFor(actor)) {
            actor.attemptsTo(WaitUntil.the(ProductPage.MODAL, isVisible()).forNoMoreThan(30).seconds(), Click.on(ProductPage.CLOSE_MODAL));
        }
    }

    private void waitForElementAndClickScroll(Actor actor, Target element) {
        actor.attemptsTo(WaitUntil.the(element, isClickable()).forNoMoreThan(30).seconds(),
                Scroll.to(element),
                Click.on(element));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(ProductPage.LISTA_PRODUCTO, isVisible()).forNoMoreThan(30).seconds());

        List<WebElement> listaProductos = ExitoQuestions.listaProductos().answeredBy(actor);
        ArrayList<Integer> listaNumerosAleatorios = CommonUtil.numerosAleatorios(1, listaProductos.size() - 1);
        ArrayList<Integer> listaNumerosCantAleatorios = CommonUtil.numerosAleatorios(rangoInicial, rangoFinal - 1);

        String[] nameProductos = new String[cantProducts];
        String[] precioProductos = new String[cantProducts];
        String[] precioProductosTotal = new String[cantProducts];
        int[] numProductsAdd = new int[cantProducts];
        double[] precioTotalNum = new double[cantProducts];
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0.000", symbols);

        for (int i = 0; i < cantProducts; i++) {
              handleModal(actor);
            nameProductos[i] = ExitoQuestions.nombreProducto(String.valueOf(listaNumerosAleatorios.get(i))).answeredBy(actor);
            precioProductos[i] = ExitoQuestions.precioProducto(String.valueOf(listaNumerosAleatorios.get(i))).answeredBy(actor);
             handleModal(actor);
            waitForElementAndClickScroll(actor, ProductPage.BTN_AGREGAR.of(String.valueOf(listaNumerosAleatorios.get(i))));

              handleModal(actor);
            for (int h = 0; h < listaNumerosCantAleatorios.get(i); h++) {
                 handleModal(actor);
                waitForElementAndClickScroll(actor, ProductPage.BTN_AGREGAR_CANT.of(String.valueOf(listaNumerosAleatorios.get(i))));
                 handleModal(actor);
            }
            handleModal(actor);
            numProductsAdd[i] = listaNumerosCantAleatorios.get(i);
            String[] precioSplit = precioProductos[i].split("[\\s\\u00A0]+");
            precioTotalNum[i] = Double.parseDouble(precioSplit[1]) * (numProductsAdd[i] + 1);
            precioProductosTotal[i] = precioSplit[0] + " " + df.format(precioTotalNum[i]);
            handleModal(actor);
        }

        int sumaCantidades = Arrays.stream(numProductsAdd).sum() + cantProducts;

        Serenity.setSessionVariable("nameProductos").to(nameProductos);
        Serenity.setSessionVariable("precioProductos").to(precioProductos);
        Serenity.setSessionVariable("cantProducts").to(cantProducts);
        Serenity.setSessionVariable("numProductsAdd").to(numProductsAdd);
        Serenity.setSessionVariable("sumaCantidades").to(sumaCantidades);
        Serenity.setSessionVariable("precioTotalNum").to(precioTotalNum);
        Serenity.setSessionVariable("precioProductosTotal").to(precioProductosTotal);
    }
}
