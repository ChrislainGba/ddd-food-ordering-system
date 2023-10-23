package com.xl1.ddd.order.service.domain.mapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.xl1.ddd.domain.valueobject.CustomerId;
import com.xl1.ddd.domain.valueobject.Money;
import com.xl1.ddd.domain.valueobject.ProductId;
import com.xl1.ddd.domain.valueobject.RestaurantId;
import com.xl1.ddd.order.service.domain.dto.create.CreateOrderCommand;
import com.xl1.ddd.order.service.domain.dto.create.CreateOrderResponse;
import com.xl1.ddd.order.service.domain.dto.create.OrderAddress;
import com.xl1.ddd.order.service.domain.entity.Order;
import com.xl1.ddd.order.service.domain.entity.OrderItem;
import com.xl1.ddd.order.service.domain.entity.Product;
import com.xl1.ddd.order.service.domain.entity.Restaurant;
import com.xl1.ddd.order.service.domain.valueobject.StreetAddress;

@Component
public class OrderDataMapper {

    public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand) {
        return Restaurant.builder()
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand.getItems().stream().map(orderItem ->
                        new Product(new ProductId(orderItem.getProductId())))
                        .collect(Collectors.toList()))
                .build();
    }
    
    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemEntities(createOrderCommand.getItems()))
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order) {
        return CreateOrderResponse.builder()
                .orderTackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .build();
    }

    private List<OrderItem> orderItemsToOrderItemEntities(
            List<com.xl1.ddd.order.service.domain.dto.create.OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem ->
                        OrderItem.builder()
                                .product(new Product(new ProductId(orderItem.getProductId())))
                                .price(new Money(orderItem.getPrice()))
                                .quantity(orderItem.getQuantity())
                                .subTotal(new Money(orderItem.getSubTotal()))
                                .build()).collect(Collectors.toList());
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress orderAddress) {
        return new StreetAddress(
                UUID.randomUUID(),
                orderAddress.getStreet(),
                orderAddress.getPostalCode(),
                orderAddress.getCity()
        );
    }
}