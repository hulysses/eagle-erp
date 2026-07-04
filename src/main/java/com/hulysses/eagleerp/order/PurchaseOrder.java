package com.hulysses.eagleerp.order;

import com.hulysses.eagleerp.payment.PaymentMethodEnum;
import com.hulysses.eagleerp.supplier.Supplier;

import java.util.List;

public class PurchaseOrder {
    private Long id;
    private List<OrderItem> items;
    private Supplier supplier;
    private PaymentMethodEnum paymentMethod;

    public PurchaseOrder(List<OrderItem> items, Supplier supplier, PaymentMethodEnum paymentMethod) {
        this.items = items;
        this.supplier = supplier;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
