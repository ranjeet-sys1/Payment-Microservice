package com.app.service.impl;

import com.app.entity.Payment;
import com.app.repo.PaymentRepository;
import com.app.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public Payment doPayment(Payment payment) {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);

    }

    @Override
    public Payment findByOrderId(Long orderId) {
        Payment paymentDetails =paymentRepository.findByOrderId(orderId);
        return paymentDetails;
    }

    public String paymentProcessing(){
        return  new Random().nextBoolean() ?"success":"false";
    }
}
