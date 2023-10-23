package com.xl1.ddd.order.service.domain.dto.create;

import java.util.UUID;

import com.xl1.ddd.domain.valueobject.OrderStatus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderResponse {
    @NotNull
    private final UUID orderTackingId;
    @NotNull
    private final OrderStatus orderStatus;
    @NotNull
    private final String message;
}
