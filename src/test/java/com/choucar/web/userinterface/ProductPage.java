package com.choucar.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage {
    public static final Target SELECT_SPAN_MENU = Target.the("Menú").located(By.xpath("//*[@id=\"__next\"]/header/section/div/div[1]/button"));
    public static final Target MODAL= Target.the("Modal").located(By.xpath("//div[@role='dialog']"));
    public static final Target LISTA_PRODUCTO= Target.the("Lista de Producto").located(By.xpath("//ul[@data-fs-product-grid-type = 'hogar']//li"));
    public static final Target CLOSE_MODAL= Target.the("Cerar Modal").located(By.id("wps-overlay-close-button"));
    public static final Target BTN_CATEGORIES = Target.the("Boton Categoria").locatedBy("//section[header[text()='Categorías']]/div/li//p[text()='{0}']/parent::div");
    public static final Target BTN_SUB_CATEGORIES = Target.the("Boton Sub Categoria").locatedBy("//div[@class = 'SubMenu_submenu-container__f05V3']//a[text()= '{0}']");
    public static final Target LBL_NAME_PRODUCT = Target.the("Nombre del Producto").locatedBy("(//ul[@data-fs-product-grid-type = 'hogar']//li)[{0}]/article/section//div/h3");
    public static final Target LBL_PRECIO_PRODUCT = Target.the("Precio del Producto").locatedBy("(//ul[@data-fs-product-grid-type = 'hogar']//li)[{0}]/article/section/div[2]/div[1]/div/div[1]/div[2]/p");
    public static final Target BTN_AGREGAR = Target.the("Agregar Producto").locatedBy("(//*[@data-fs-product-grid-type = 'hogar']//li)[{0}]//div[2]/div[2]/button");
    public static final Target BTN_AGREGAR_CANT = Target.the("Agregar Cantidad del Producto").locatedBy("(//*[@data-fs-product-grid-type = 'hogar']//li)[{0}]//div[2]/div[2]//button[2]");
    public static final Target BTN_CARRITO = Target.the("Carrito").located(By.xpath("//button[@data-testid= 'cart-toggle']"));


    public static final Target LBL_NOMBRE_PRODUCTO_CARRITO = Target.the("Agregar Cantidad del Producto").locatedBy("//*[@class='exito-checkout-io-0-x-itemCartContent'][{0}]/div/div[4]/span");
    public static final Target LBL_PRECIO_PRODUCTO_CARRITO = Target.the("Agregar Cantidad del Producto").locatedBy("//*[text()='{0}']/parent::div/following-sibling::div[1]/div/span");
    public static final Target LBL_CANTIDAD_PRODUCTO_CARRITO = Target.the("Agregar Cantidad del Producto").locatedBy("//*[text()='{0}']/parent::div/following-sibling::div[2]/div/div[1]//span[1]");

}
