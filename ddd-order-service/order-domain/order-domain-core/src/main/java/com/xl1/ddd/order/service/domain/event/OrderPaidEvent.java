package com.xl1.ddd.order.service.domain.event;

import java.time.ZonedDateTime;

import com.xl1.ddd.domain.event.publisher.DomainEventPublisher;
import com.xl1.ddd.order.service.domain.entity.Order;

public class OrderPaidEvent extends OrderEvent {

	 private final DomainEventPublisher<OrderPaidEvent> orderPaidEventDomainEventPublisher;

	    public OrderPaidEvent(Order order,
	                          ZonedDateTime createdAt,
	                          DomainEventPublisher<OrderPaidEvent> orderPaidEventDomainEventPublisher) {
	        super(order, createdAt);
	        this.orderPaidEventDomainEventPublisher = orderPaidEventDomainEventPublisher;
	    }
}
