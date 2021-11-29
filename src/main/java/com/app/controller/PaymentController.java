package com.app.controller;

import com.app.entity.Payment;
import com.app.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("doPayment")
    public ResponseEntity doPayment(@RequestBody Payment payment){
        Payment doPayment = paymentService.doPayment(payment);
        return new ResponseEntity(doPayment, HttpStatus.CREATED);

    }
}