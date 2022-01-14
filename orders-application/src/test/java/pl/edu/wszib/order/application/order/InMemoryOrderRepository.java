package pl.edu.wszib.order.application.order;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryOrderRepository implements OrderRepository {
    private final Map<OrderId, Order> orders = new HashMap<>();

    @Override
    public Order save(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public Optional<Order> findById(OrderId id) {
        return Optional.ofNullable(orders.get(id));
    }
}
