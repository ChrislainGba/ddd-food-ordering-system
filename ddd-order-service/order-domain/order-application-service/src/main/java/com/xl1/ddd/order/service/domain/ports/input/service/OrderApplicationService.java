package com.xl1.ddd.order.service.domain.ports.input.service;

import com.xl1.ddd.order.service.domain.dto.create.CreateOrderCommand;
import com.xl1.ddd.order.service.domain.dto.create.CreateOrderResponse;
import com.xl1.ddd.order.service.domain.dto.track.TrackOrderQuery;
import com.xl1.ddd.order.service.domain.dto.track.TrackOrderResponse;

import jakarta.validation.Valid;

public interface OrderApplicationService {
	
	CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);

    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);

}
