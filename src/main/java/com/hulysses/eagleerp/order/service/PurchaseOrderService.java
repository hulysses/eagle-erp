package com.hulysses.eagleerp.order.service;

import com.hulysses.eagleerp.order.InvalidOrderException;
import com.hulysses.eagleerp.order.PurchaseOrder;
import com.hulysses.eagleerp.order.repository.PurchaseOrderRepository;
import com.hulysses.eagleerp.payment.PaymentMethodEnum;
import com.hulysses.eagleerp.payment.service.PaymentService;
import com.hulysses.eagleerp.supplier.Supplier;

import java.util.List;

public class PurchaseOrderService {

    private final PaymentService paymentService;
    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderService(PaymentService paymentService, PurchaseOrderRepository purchaseOrderRepository) {
        this.paymentService = paymentService;
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    public PurchaseOrder createOrder(
            Supplier supplier,
            PaymentMethodEnum paymentMethod
    ) {
        PurchaseOrder order = new PurchaseOrder(supplier, paymentMethod);
        purchaseOrderRepository.save(order);

        return order;
    }

    public void checkout(PurchaseOrder order) {
        validateOrder(order);
        paymentService.process(order);
    }

    public List<PurchaseOrder> findAll() {
        return purchaseOrderRepository.findAll();
    }

    private void validateOrder(PurchaseOrder order) {
        if (!order.hasItems()) {
            throw new InvalidOrderException("Purchase order must have at least one item.");
        }
    }
}
