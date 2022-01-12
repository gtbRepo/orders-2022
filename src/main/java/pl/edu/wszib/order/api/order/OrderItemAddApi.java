package pl.edu.wszib.order.api.order;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
public class OrderItemAddApi {
    private final String productId;
    private final Integer quantity;
}
