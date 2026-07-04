package com.hulysses.eagleerp.payment;

import com.hulysses.eagleerp.order.PurchaseOrder;

public interface PaymentStrategy {
    void pay(PurchaseOrder order);
}
