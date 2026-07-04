package com.hulysses.eagleerp.payment.adapter;

import com.hulysses.eagleerp.order.PurchaseOrder;

public interface PaymentGateway {
    void process(PurchaseOrder order);
}
