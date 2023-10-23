package com.xl1.ddd.order.service.domain.valueobject;

import java.util.UUID;

import com.xl1.ddd.domain.valueobject.BaseId;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
