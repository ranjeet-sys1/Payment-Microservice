package com.app.service;


import com.app.entity.Payment;

public interface PaymentService {
    Payment doPayment(Payment payment);

    Payment findByOrderId(Long orderId);
}
