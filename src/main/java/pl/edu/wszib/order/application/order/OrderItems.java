package pl.edu.wszib.order.application.order;

import java.util.HashSet;
import java.util.Set;

public class OrderItems {
    public OrderItems(Set<OrderItem> items) {
        this.items = items;
    }

    private final Set<OrderItem> items;

    public static OrderItems create() {
        return new OrderItems(new HashSet<>());
    }

    public OrderItems add(OrderItem orderItem) {
        items.add(orderItem);
        return new OrderItems(items);
    }
}
