package com.hulysses.eagleerp.payment.strategy;

import com.hulysses.eagleerp.order.PurchaseOrder;

public class CreditCardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(PurchaseOrder order) {
        System.out.println("Processing credit card payment: " + order.calculateTotal());
    }
}