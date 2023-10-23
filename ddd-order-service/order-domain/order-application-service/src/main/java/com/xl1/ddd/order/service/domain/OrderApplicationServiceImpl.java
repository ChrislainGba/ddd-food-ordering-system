package com.xl1.ddd.order.service.domain;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.xl1.ddd.order.service.domain.dto.create.CreateOrderCommand;
import com.xl1.ddd.order.service.domain.dto.create.CreateOrderResponse;
import com.xl1.ddd.order.service.domain.dto.track.TrackOrderQuery;
import com.xl1.ddd.order.service.domain.dto.track.TrackOrderResponse;
import com.xl1.ddd.order.service.domain.ports.input.service.OrderApplicationService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Service
@Validated
@Slf4j
public class OrderApplicationServiceImpl implements OrderApplicationService{
	
	private final OrderCreateCommandHandler orderCreateCommandHandler;

	private final OrderTrackCommandHandler orderTrackCommandHandler;

    public OrderApplicationServiceImpl(OrderCreateCommandHandler orderCreateCommandHandler,
                                       OrderTrackCommandHandler orderTrackCommandHandler) {
        this.orderCreateCommandHandler = orderCreateCommandHandler;
        this.orderTrackCommandHandler = orderTrackCommandHandler;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        return orderCreateCommandHandler.createOrder(createOrderCommand);
    }

    @Override
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        return orderTrackCommandHandler.trackOrder(trackOrderQuery);
    }

}
