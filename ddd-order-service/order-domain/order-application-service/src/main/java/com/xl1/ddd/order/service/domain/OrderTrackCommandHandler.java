package com.xl1.ddd.order.service.domain;

import org.springframework.stereotype.Component;

import com.xl1.ddd.order.service.domain.dto.track.TrackOrderQuery;
import com.xl1.ddd.order.service.domain.dto.track.TrackOrderResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OrderTrackCommandHandler {

    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        return null;
    }
}
