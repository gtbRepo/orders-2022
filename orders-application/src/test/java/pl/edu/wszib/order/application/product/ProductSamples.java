package pl.edu.wszib.order.application.product;

import java.math.BigDecimal;

public class ProductSamples {
    //TODO dodać więcej produktów
    public static final Product CHOCKOLATE = new Product(ProductId.create(), "Czekolada", BigDecimal.valueOf(4));
    public static final Product COCA_COLA_ZERO = new Product(ProductId.create(), "Coca-cola-zero", BigDecimal.valueOf(5));
}
