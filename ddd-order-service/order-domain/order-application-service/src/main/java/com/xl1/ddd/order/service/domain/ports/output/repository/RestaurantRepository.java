package com.xl1.ddd.order.service.domain.ports.output.repository;

import java.util.Optional;

import com.xl1.ddd.order.service.domain.entity.Restaurant;

public interface RestaurantRepository {

    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
