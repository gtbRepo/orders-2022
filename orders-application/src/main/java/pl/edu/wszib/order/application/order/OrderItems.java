package pl.edu.wszib.order.application.order;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.ToString;
import pl.edu.wszib.order.api.OrderItemApi;

@AllArgsConstructor
@ToString
public class OrderItems {
    private final Set<OrderItem> items;

    public static OrderItems create() {
        return new OrderItems(new HashSet<>());
    }

    OrderItems add(OrderItem orderItem) {
        items.add(orderItem);
        return new OrderItems(items);

    }

    public Set<OrderItemApi> toApi() {
        return items.stream()
                .map(OrderItem::toApi)
                .collect(Collectors.toSet());
    }

    OrderItems remove(final String productId) {
        items.removeIf(item -> item.hasProductId(productId));
        return new OrderItems(items);
    }
}
