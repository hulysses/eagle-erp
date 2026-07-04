package com.hulysses.eagleerp.payment;

import com.hulysses.eagleerp.order.PurchaseOrder;

public class PixPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(PurchaseOrder order) {
        System.out.println("Processing PIX payment: " + order.calculateTotal());
    }
}