package com.choucar.web.questions;

import com.choucar.web.userinterface.ProductPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.questions.Value;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExitoQuestions {
    public static Question<List<WebElement>> listaProductos() {
        return actor -> (List<WebElement>) BrowseTheWeb.as(actor).getDriver().findElements(By.xpath("//ul[@data-fs-product-grid-type = 'hogar']//li"));
    }

    public static Question<String> nombreProducto(String numero) {
        return actor -> TextContent.of(ProductPage.LBL_NAME_PRODUCT.of(numero).called(numero)).answeredBy(actor).trim();
    }

    public static Question<String> precioProducto(String numero) {
        return actor -> TextContent.of(ProductPage.LBL_PRECIO_PRODUCT.of(numero).called(numero)).answeredBy(actor).trim();
    }

    public static Question<String> modal() {
        return actor -> TextContent.of(ProductPage.MODAL).answeredBy(actor).trim();
    }

    public static Question<Boolean> nombreProductoCarrito(String numero, String nombreProducto) {
        return actor -> {
            String nombreProductoCarrito = TextContent.of(ProductPage.LBL_NOMBRE_PRODUCTO_CARRITO.of(numero)).answeredBy(actor).trim();
            return nombreProductoCarrito.contains(nombreProducto);
        };
    }

    public static Question<Boolean> precioProductoCarrito(String nombreProducto, String precioProducto) {
        return actor -> {
            String precioProductoObtenido = TextContent.of(ProductPage.LBL_PRECIO_PRODUCTO_CARRITO.of(nombreProducto)).answeredBy(actor).trim();
            // Elimina todos los caracteres no numéricos, excepto el punto decimal
            String precioProductoObtenidoNumerico = precioProductoObtenido.replaceAll("[^\\d.]", "");

            // Compara los valores numéricos
            return precioProducto.contains(precioProductoObtenidoNumerico);
        };
    }

    public static Question<Boolean> cantProductoCarrito(String nombreProducto, String cantProducts) {
        return actor -> {
            String cantidadProducto = TextContent.of(ProductPage.LBL_CANTIDAD_PRODUCTO_CARRITO.of(nombreProducto)).answeredBy(actor).trim();
            return cantidadProducto.contains(cantProducts);
        };
    }

    public static Question<List<WebElement>> listaProductosCarrito() {
        return actor -> (List<WebElement>) BrowseTheWeb.as(actor).getDriver().findElements(By.xpath("//div[@class = 'exito-checkout-io-0-x-itemCartContainer']/div"));
    }
}
