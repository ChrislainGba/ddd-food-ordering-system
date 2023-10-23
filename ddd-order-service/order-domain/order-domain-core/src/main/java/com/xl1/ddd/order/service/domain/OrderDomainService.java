package com.xl1.ddd.order.service.domain;

import java.util.List;

import com.xl1.ddd.order.service.domain.entity.Order;
import com.xl1.ddd.order.service.domain.entity.Restaurant;
import com.xl1.ddd.order.service.domain.event.OrderCancelledEvent;
import com.xl1.ddd.order.service.domain.event.OrderCreatedEvent;
import com.xl1.ddd.order.service.domain.event.OrderPaidEvent;

public interface OrderDomainService {
	
	OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);
}
