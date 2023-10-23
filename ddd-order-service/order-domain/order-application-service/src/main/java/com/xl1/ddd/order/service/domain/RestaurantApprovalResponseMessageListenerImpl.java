package com.xl1.ddd.order.service.domain;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.xl1.ddd.order.service.domain.dto.message.RestaurantApprovalResponse;
import com.xl1.ddd.order.service.domain.ports.input.message.listener.restaurantapproval.RestaurantApprovalResponseMessageListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@Service
public class RestaurantApprovalResponseMessageListenerImpl implements RestaurantApprovalResponseMessageListener{

	@Override
	public void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse) {
		// TODO Auto-generated method stub
		
	}

}
