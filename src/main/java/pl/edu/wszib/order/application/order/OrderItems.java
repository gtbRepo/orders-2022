package pl.edu.wszib.order.application.order;

import pl.edu.wszib.order.application.order.OrderItem;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.ToString;

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
}
