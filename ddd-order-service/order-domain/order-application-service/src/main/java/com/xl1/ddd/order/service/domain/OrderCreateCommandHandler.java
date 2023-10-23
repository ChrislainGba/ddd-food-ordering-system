package com.xl1.ddd.order.service.domain;

import org.springframework.stereotype.Component;

import com.xl1.ddd.order.service.domain.dto.create.CreateOrderCommand;
import com.xl1.ddd.order.service.domain.dto.create.CreateOrderResponse;
import com.xl1.ddd.order.service.domain.event.OrderCreatedEvent;
import com.xl1.ddd.order.service.domain.mapper.OrderDataMapper;
import com.xl1.ddd.order.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OrderCreateCommandHandler {
	
	private final OrderCreateHelper orderCreateHelper;

    private final OrderDataMapper orderDataMapper;

    private final OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher;

    public OrderCreateCommandHandler(OrderCreateHelper orderCreateHelper,
                                     OrderDataMapper orderDataMapper,
                                     OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher) {
        this.orderCreateHelper = orderCreateHelper;
        this.orderDataMapper = orderDataMapper;
        this.orderCreatedPaymentRequestMessagePublisher = orderCreatedPaymentRequestMessagePublisher;
    }

    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        OrderCreatedEvent orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand);
        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
        orderCreatedPaymentRequestMessagePublisher.publish(orderCreatedEvent);
        return orderDataMapper.orderToCreateOrderResponse(orderCreatedEvent.getOrder());
    }

}