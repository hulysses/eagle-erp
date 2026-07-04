package com.hulysses.eagleerp.payment.strategy;

import com.hulysses.eagleerp.order.PurchaseOrder;

public interface PaymentStrategy {
    void pay(PurchaseOrder order);
}
