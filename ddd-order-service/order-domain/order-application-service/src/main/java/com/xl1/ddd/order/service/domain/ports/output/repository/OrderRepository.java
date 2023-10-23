package com.xl1.ddd.order.service.domain.ports.output.repository;

import java.util.Optional;

import com.xl1.ddd.order.service.domain.entity.Order;
import com.xl1.ddd.order.service.domain.valueobject.TrackingId;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findByTrackingId(TrackingId trackingId);
}
