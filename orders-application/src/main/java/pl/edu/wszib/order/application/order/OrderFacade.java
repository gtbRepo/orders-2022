package pl.edu.wszib.order.application.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import pl.edu.wszib.order.api.OrderApi;
import pl.edu.wszib.order.api.OrderApiResult;
import pl.edu.wszib.order.api.OrderError;
import pl.edu.wszib.order.application.product.Product;
import pl.edu.wszib.order.application.product.ProductFacade;

import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class OrderFacade {
    private final OrderRepository orderRepository;
    private final ProductFacade productFacade;

    public OrderApi create() {
        final Order order = Order.create();
        orderRepository.save(order);
        return order.toApi();
    }
    public Optional<OrderApi> findById(final String id) {
        return findById(OrderId.of(id));

    }

    public Optional<OrderApi> findById(final OrderId id) {
        return orderRepository.findById(id)
                .map(Order::toApi);
    }

    public OrderApiResult addItem(final String orderId,
                                  final String productId,
                                  final Integer quantity) {
        return orderRepository.findById(orderId)
                .map(order -> addItem(order, productId, quantity))
                .orElseGet(() -> OrderApiResult.failure(OrderError.ORDER_NOT_FOUND));
    }

    //TODO Refactor
    private OrderApiResult addItem(final Order order,
                                   final String productId,
                                  final Integer quantity){
        final Optional<Product> product = productFacade.findById(productId);
        if(product.isEmpty()){
            return OrderApiResult.failure(OrderError.PRODUCT_NOT_FOUND);
        }
        final OrderItem orderItem = OrderItem.create(product.get(), quantity);
        final Order modifiedOrder = order.addItem(orderItem);
        return OrderApiResult.success(orderRepository.save(modifiedOrder).toApi());
    }

    public OrderApi findByIdOrThrow(final String orderId) {
        return findById(orderId)
                .orElseThrow();
    }

    public OrderApiResult removeItem(final String orderId,
                                     final String productId) {
        return orderRepository.findById(orderId)
                .map(order -> order.removeItem(productId))
                .map(orderRepository::save)
                .map(Order::toApi)
                .map(OrderApiResult::success)
                .orElseGet(() -> OrderApiResult.failure(OrderError.ORDER_NOT_FOUND));
    }
}
