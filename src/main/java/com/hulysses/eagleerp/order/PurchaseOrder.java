package com.hulysses.eagleerp.order;

import com.hulysses.eagleerp.payment.PaymentMethodEnum;
import com.hulysses.eagleerp.supplier.Supplier;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseOrder {
    private Long id;
    private List<OrderItem> items;
    private Supplier supplier;
    private PaymentMethodEnum paymentMethod;

    public PurchaseOrder(List<OrderItem> items, Supplier supplier, PaymentMethodEnum paymentMethod) {
        validateSupplier(supplier);
        validatePaymentMethod(paymentMethod);

        this.items = items;
        this.supplier = supplier;
        this.paymentMethod = paymentMethod;
    }

    public void addItem(OrderItem item) {
        validateItem(item);
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        validateItem(item);
        items.remove(item);
    }

    public BigDecimal calculateTotal() {
        return items.stream()
                .map(OrderItem::calculateSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean hasItems() {
        return !items.isEmpty();
    }

    private void validateSupplier(Supplier supplier) {
        if (supplier == null) {
            throw new InvalidOrderException("Supplier is required.");
        }
    }

    private void validatePaymentMethod(PaymentMethodEnum paymentMethod) {
        if (paymentMethod == null) {
            throw new InvalidOrderException("Payment method is required.");
        }
    }

    private void validateItem(OrderItem item) {
        if (item == null) {
            throw new InvalidOrderException("Order item is required.");
        }
    }

    public Long getId() {
        return id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }
}
