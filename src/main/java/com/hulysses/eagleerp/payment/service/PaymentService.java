package com.hulysses.eagleerp.payment.service;

import com.hulysses.eagleerp.order.PurchaseOrder;
import com.hulysses.eagleerp.payment.adapter.PaymentGateway;
import com.hulysses.eagleerp.payment.factory.PaymentStrategyFactory;
import com.hulysses.eagleerp.payment.strategy.PaymentStrategy;

public class PaymentService {

    private final PaymentStrategyFactory paymentStrategyFactory;
    private final PaymentGateway paymentGateway;

    public PaymentService(
            PaymentStrategyFactory paymentStrategyFactory,
            PaymentGateway paymentGateway
    ) {
        this.paymentStrategyFactory = paymentStrategyFactory;
        this.paymentGateway = paymentGateway;
    }

    public void process(PurchaseOrder order) {
        PaymentStrategy paymentStrategy = paymentStrategyFactory.create(
                order.getPaymentMethod()
        );

        paymentStrategy.pay(order);
        paymentGateway.process(order);
    }
}
