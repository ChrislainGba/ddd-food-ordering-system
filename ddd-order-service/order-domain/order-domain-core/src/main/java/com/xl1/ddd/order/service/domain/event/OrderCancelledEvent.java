package com.xl1.ddd.order.service.domain.event;

import java.time.ZonedDateTime;

import com.xl1.ddd.order.service.domain.entity.Order;

public class OrderCancelledEvent extends OrderEvent {

    public OrderCancelledEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
