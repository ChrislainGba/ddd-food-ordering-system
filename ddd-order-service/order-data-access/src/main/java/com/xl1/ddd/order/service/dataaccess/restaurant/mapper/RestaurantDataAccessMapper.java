package com.xl1.ddd.order.service.dataaccess.restaurant.mapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.xl1.ddd.domain.valueobject.Money;
import com.xl1.ddd.domain.valueobject.ProductId;
import com.xl1.ddd.domain.valueobject.RestaurantId;
import com.xl1.ddd.order.service.dataaccess.restaurant.entity.RestaurantEntity;
import com.xl1.ddd.order.service.dataaccess.restaurant.exception.RestaurantDataAccessException;
import com.xl1.ddd.order.service.domain.entity.Product;
import com.xl1.ddd.order.service.domain.entity.Restaurant;

@Component
public class RestaurantDataAccessMapper {

    public List<UUID> restaurantToRestaurantProducts(Restaurant restaurant) {
        return restaurant.getProducts().stream()
                .map(product -> product.getId().getValue())
                .collect(Collectors.toList());
    }

    public Restaurant restaurantEntityToRestaurant(List<RestaurantEntity> restaurantEntities) {
        RestaurantEntity restaurantEntity =
                restaurantEntities.stream().findFirst().orElseThrow(() ->
                        new RestaurantDataAccessException("Restaurant could not be found!"));

        List<Product> restaurantProducts = restaurantEntities.stream().map(entity ->
                new Product(new ProductId(entity.getProductId()), entity.getProductName(),
                        new Money(entity.getProductPrice()))).toList();

        return Restaurant.builder()
                .restaurantId(new RestaurantId(restaurantEntity.getRestaurantId()))
                .products(restaurantProducts)
                .active(restaurantEntity.getRestaurantActive())
                .build();
    }
}
