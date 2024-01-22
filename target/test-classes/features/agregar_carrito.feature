@Exito
Feature: Añadir Producto
  # Redacciòn Declarativa
  @añado_producto
  Scenario Outline: Añadir Productos de la Tienda Éxito
  Descripcion: Se desea añadir 5 productos aleatoriamente de la Categoría Dormitorio
    Given que soy un usuario en el sitio web de Tiendas Éxito
    When  selecciono la categoría <categoria> y la subcategoría <subcategoria>
    And   añado 5 productos aleatorios con cantidades entre 1 y 10 al carrito
    Then  valido el número de productos agregados debe ser igual que en el carrito
    And   valido las cantidades de los productos agregados deberá ser igual que en el carrito
    And   valido el nombre de los productos del carrito que deben ser iguales a los productos seleccionados
    And   valido el total de los precios de los productos agregados deberá ser igual que en el carrito

    Examples:
      | categoria  | subcategoria |
      | Dormitorio | Cabeceras    |

