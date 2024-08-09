package pl.edu.wszib.order.application.order;

import lombok.AllArgsConstructor;
import lombok.ToString;
import pl.edu.wszib.order.application.product.Product;

import java.math.BigDecimal;

@AllArgsConstructor
@ToString
public class OrderItem {
    private final Product product;
    private final Integer quantity;
    private final BigDecimal amount;
}
