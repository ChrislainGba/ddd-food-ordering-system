package com.xl1.ddd.order.service.domain.ports.output.message.publisher.restaurantapproval;

import com.xl1.ddd.domain.event.publisher.DomainEventPublisher;
import com.xl1.ddd.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
