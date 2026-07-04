package com.hulysses.eagleerp.payment;

import com.hulysses.eagleerp.order.PurchaseOrder;

public class BoletoPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(PurchaseOrder order) {
        System.out.println("Processing boleto payment: " + order.calculateTotal());
    }
}