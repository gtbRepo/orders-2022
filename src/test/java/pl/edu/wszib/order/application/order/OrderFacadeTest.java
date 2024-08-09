package pl.edu.wszib.order.application.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderFacadeTest {

    //T1: można stworzyć zamówienie
    //T2: można dodać pozycję do zamówieia
    //T3: mozna usunąć pozycję
    //T4: można zwiększyć ilość dla pozycji
    //T5: można zmiejszyć ilość dla pozycji
    //T6: dodanie pozycji przedmiotu, który znajduje się
    // już w zamówieniu powinno skutować zwiększeniem jego ilości.
    //T7: można ukończyć zamówienie
    //T8: nie można modyfikować ukończonego zamówienia

    private OrderFacade orderFacade;

    @BeforeEach
    public void setup() {
        final OrderRepository orderRepository = new InMemoryOrderRepository();
        orderFacade =  new OrderFacade(orderRepository);
    }

    @Test
    public void should_be_able_to_create_order() {
        //given:

        //when:
        final Order createdOrder = orderFacade.create();

        //then:
        final Optional<Order> foundOrder
                = orderFacade.findById(createdOrder.getId());
        assertTrue(foundOrder.isPresent());
        System.out.println("Order has been created! order = " + createdOrder);
    }
}