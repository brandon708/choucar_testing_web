package com.choucar.web.questions;


import io.cucumber.java.PendingException;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ValidacionQuestions {

    public static Question<Boolean> cantiProductosCarrito(int cantProductos) {

        boolean resultado = false;
        List<WebElement> cantProductosCarrito = ExitoQuestions.listaProductosCarrito().answeredBy(theActorInTheSpotlight());

        if(cantProductosCarrito.size() == cantProductos){
            resultado =true;
        }

        boolean finalResultado = resultado;
        return actor -> finalResultado;
    }

    public static Question<Boolean> nombreProductos(String[] nombreProductos) {

        boolean resultado = false;
        int NombreValidado = 0;

        for(int i= 0; i<nombreProductos.length;i++){
            for(int j= 1; j<=nombreProductos.length;j++) {
                if (ExitoQuestions.nombreProductoCarrito(String.valueOf(j), nombreProductos[i]).answeredBy(theActorInTheSpotlight())) {
                    NombreValidado++;
                    break;
                }
            }
        }

        if(NombreValidado == nombreProductos.length){
            resultado = true;
        }

        boolean finalResultado = resultado;
        return actor -> finalResultado;
    }

    public static Question<Boolean> precioProductos(String[] nombreProducto, String[] precioTotalProductos) {

        boolean resultado = false;
        int PrecioTotalValidado = 0;

        for(int i= 0; i<nombreProducto.length;i++){
                if (ExitoQuestions.precioProductoCarrito(nombreProducto[i], precioTotalProductos[i]).answeredBy(theActorInTheSpotlight())) {
                    PrecioTotalValidado++;
                }
        }

        if(PrecioTotalValidado == precioTotalProductos.length){
            resultado = true;
        }

        boolean finalResultado = resultado;
        return actor -> finalResultado;
    }



    public static Question<Boolean> cantProductos(String[] nombreProducto, String[] cantProductosAgregados) {

        boolean resultado = false;
        int cantProductosValidados = 0;

        for(int i= 0; i<nombreProducto.length;i++){
            if (ExitoQuestions.cantProductoCarrito(nombreProducto[i], cantProductosAgregados[i]).answeredBy(theActorInTheSpotlight())) {
                cantProductosValidados++;
            }
        }

        if(cantProductosValidados == cantProductosAgregados.length){
            resultado = true;
        }

        boolean finalResultado = resultado;
        return actor -> finalResultado;
    }
}