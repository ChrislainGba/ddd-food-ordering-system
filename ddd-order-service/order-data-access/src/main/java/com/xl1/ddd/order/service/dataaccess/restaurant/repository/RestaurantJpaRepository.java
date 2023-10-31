package com.xl1.ddd.order.service.dataaccess.restaurant.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xl1.ddd.order.service.dataaccess.restaurant.entity.RestaurantEntity;
import com.xl1.ddd.order.service.dataaccess.restaurant.entity.RestaurantEntityId;

@Repository
public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity, RestaurantEntityId> {

    Optional<List<RestaurantEntity>> findByRestaurantIdAndProductIdIn(UUID restaurantId, List<UUID> productIds);
}
