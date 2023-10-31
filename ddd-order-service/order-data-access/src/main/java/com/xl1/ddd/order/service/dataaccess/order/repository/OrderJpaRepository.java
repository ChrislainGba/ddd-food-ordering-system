package com.xl1.ddd.order.service.dataaccess.order.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xl1.ddd.order.service.dataaccess.order.entity.OrderEntity;

import jakarta.transaction.Transactional;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {

    Optional<OrderEntity> findByTrackingId(UUID trackingId);
    
    /**@Modifying
    @Transactional
    @Query("INSERT INTO OrderEntity o (o.customerId, o.failureMessages, o.orderStatus, o.price, o.restaurantId, o.trackingId) " +
           "VALUES (:#{#order.customerId}, :#{#order.failureMessages}, :#{#order.getOrderStatusString()}, " +
           ":#{#order.price}, :#{#order.restaurantId}, :#{#order.trackingId})")
    void saveOrder(@Param("order") OrderEntity order);**/
}

