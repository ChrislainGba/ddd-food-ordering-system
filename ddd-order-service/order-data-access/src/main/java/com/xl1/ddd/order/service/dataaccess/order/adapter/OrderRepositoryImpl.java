package com.xl1.ddd.order.service.dataaccess.order.adapter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.xl1.ddd.order.service.dataaccess.order.mapper.OrderDataAccessMapper;
import com.xl1.ddd.order.service.dataaccess.order.repository.OrderJpaRepository;
import com.xl1.ddd.order.service.domain.entity.Order;
import com.xl1.ddd.order.service.domain.ports.output.repository.OrderRepository;
import com.xl1.ddd.order.service.domain.valueobject.TrackingId;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderDataAccessMapper orderDataAccessMapper;

    public OrderRepositoryImpl(OrderJpaRepository orderJpaRepository,
                               OrderDataAccessMapper orderDataAccessMapper) {
        this.orderJpaRepository = orderJpaRepository;
        this.orderDataAccessMapper = orderDataAccessMapper;
    }

    @Override
    public Order save(Order order) {
        return orderDataAccessMapper.orderEntityToOrder(orderJpaRepository
                .save(orderDataAccessMapper.orderToOrderEntity(order)));
    }

    @Override
    public Optional<Order> findByTrackingId(TrackingId trackingId) {
        return orderJpaRepository.findByTrackingId(trackingId.getValue())
                .map(orderDataAccessMapper::orderEntityToOrder);
    }
}

