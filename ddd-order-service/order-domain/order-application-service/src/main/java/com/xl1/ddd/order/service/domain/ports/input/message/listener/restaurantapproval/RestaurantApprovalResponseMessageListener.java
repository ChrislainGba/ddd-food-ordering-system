package com.xl1.ddd.order.service.domain.ports.input.message.listener.restaurantapproval;

import com.xl1.ddd.order.service.domain.dto.message.RestaurantApprovalResponse;

public interface RestaurantApprovalResponseMessageListener {
	
	 void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse);

	 void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse);
}
