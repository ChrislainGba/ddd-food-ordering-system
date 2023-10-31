package com.xl1.ddd.order.service.domain.event;

import java.time.ZonedDateTime;

import com.xl1.ddd.domain.event.publisher.DomainEventPublisher;
import com.xl1.ddd.order.service.domain.entity.Order;

public class OrderCreatedEvent extends OrderEvent{
	
	private final DomainEventPublisher<OrderCreatedEvent> orderCreatedEventDomainEventPublisher;

	public OrderCreatedEvent(Order order,
            ZonedDateTime createdAt,
            DomainEventPublisher<OrderCreatedEvent> orderCreatedEventDomainEventPublisher) {
	super(order, createdAt);
	this.orderCreatedEventDomainEventPublisher = orderCreatedEventDomainEventPublisher;
	}

}
