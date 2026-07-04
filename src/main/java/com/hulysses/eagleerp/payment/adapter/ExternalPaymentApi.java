package com.hulysses.eagleerp.payment.adapter;

import java.math.BigDecimal;

public class ExternalPaymentApi {

    public void executePayment(BigDecimal amount) {
        System.out.println("External payment API processing amount: " + amount);
    }
}