package com.xl1.ddd.order.service.domain.event;

import java.time.ZonedDateTime;

import com.xl1.ddd.domain.event.DomainEvent;
import com.xl1.ddd.order.service.domain.entity.Order;

public abstract class OrderEvent implements DomainEvent<Order>{

	private final Order order;
    private final ZonedDateTime createdAt;

    public OrderEvent(Order order, ZonedDateTime createdAt) {
        this.order = order;
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
	
}
