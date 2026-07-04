package com.hulysses.eagleerp.order.service;

import com.hulysses.eagleerp.order.InvalidOrderException;
import com.hulysses.eagleerp.order.PurchaseOrder;
import com.hulysses.eagleerp.payment.PaymentMethodEnum;
import com.hulysses.eagleerp.payment.service.PaymentService;
import com.hulysses.eagleerp.supplier.Supplier;

public class PurchaseOrderService {

    private final PaymentService paymentService;

    public PurchaseOrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public PurchaseOrder createOrder(
            Supplier supplier,
            PaymentMethodEnum paymentMethod
    ) {
        return new PurchaseOrder(supplier, paymentMethod);
    }

    public void checkout(PurchaseOrder order) {
        validateOrder(order);
        paymentService.process(order);
    }

    private void validateOrder(PurchaseOrder order) {
        if (!order.hasItems()) {
            throw new InvalidOrderException("Purchase order must have at least one item.");
        }
    }
}
