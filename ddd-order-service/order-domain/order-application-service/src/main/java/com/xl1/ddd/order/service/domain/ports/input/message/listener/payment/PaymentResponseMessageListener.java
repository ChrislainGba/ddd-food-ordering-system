package com.xl1.ddd.order.service.domain.ports.input.message.listener.payment;

import com.xl1.ddd.order.service.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {
	
	void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}
