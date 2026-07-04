package com.hulysses.eagleerp.payment.adapter;

import com.hulysses.eagleerp.order.PurchaseOrder;

public class ExternalPaymentGatewayAdapter implements PaymentGateway {

    private final ExternalPaymentApi externalPaymentApi;

    public ExternalPaymentGatewayAdapter(ExternalPaymentApi externalPaymentApi) {
        this.externalPaymentApi = externalPaymentApi;
    }

    @Override
    public void process(PurchaseOrder order) {
        externalPaymentApi.executePayment(order.calculateTotal());
    }
}
