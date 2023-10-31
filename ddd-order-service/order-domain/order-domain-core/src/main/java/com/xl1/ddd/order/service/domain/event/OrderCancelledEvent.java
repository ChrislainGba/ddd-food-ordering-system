package com.xl1.ddd.order.service.domain.event;

import java.time.ZonedDateTime;

import com.xl1.ddd.domain.event.publisher.DomainEventPublisher;
import com.xl1.ddd.order.service.domain.entity.Order;

public class OrderCancelledEvent extends OrderEvent {

	private final DomainEventPublisher<OrderCancelledEvent> orderCancelledEventDomainEventPublisher;

    public OrderCancelledEvent(Order order,
                               ZonedDateTime createdAt,
                               DomainEventPublisher<OrderCancelledEvent> orderCancelledEventDomainEventPublisher) {
        super(order, createdAt);
        this.orderCancelledEventDomainEventPublisher = orderCancelledEventDomainEventPublisher;
    }

}
