package pl.edu.wszib.order.application.product;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Product {
    private final ProductId id;
    private final String name;
    // można docelowo przejść na:
    // https://github.com/JavaMoney/jsr354-api
    private final BigDecimal price;
}
