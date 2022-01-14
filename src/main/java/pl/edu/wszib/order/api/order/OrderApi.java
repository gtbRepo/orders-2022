package pl.edu.wszib.order.api.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import pl.edu.wszib.order.application.order.OrderState;

import java.math.BigDecimal;
import java.util.Set;

@Value
public class OrderApi {
    @NotBlank
    private final String id;
    @NotNull
    private final OrderState state;
    @NotEmpty
    private final Set<OrderItemApi> items;
    @NotNull
    private final BigDecimal amount;

    public boolean notContainsProduct(final String productId) {
        return !containsProduct(productId);
    }

    public boolean containsProduct(final String productId){
        return items.stream()
                .anyMatch(item -> item.hasProductId(productId));
    }
}
