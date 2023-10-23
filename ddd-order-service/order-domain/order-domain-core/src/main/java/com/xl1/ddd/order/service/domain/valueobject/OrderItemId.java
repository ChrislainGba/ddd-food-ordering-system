package com.xl1.ddd.order.service.domain.valueobject;

import com.xl1.ddd.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
