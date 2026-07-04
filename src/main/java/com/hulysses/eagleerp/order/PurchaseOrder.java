package com.hulysses.eagleerp.order;

import com.hulysses.eagleerp.payment.PaymentMethodEnum;
import com.hulysses.eagleerp.product.Product;
import com.hulysses.eagleerp.supplier.Supplier;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrder {
    private Long id;
    private final List<OrderItem> items = new ArrayList<>();
    private Supplier supplier;
    private PaymentMethodEnum paymentMethod;

    public PurchaseOrder(Supplier supplier, PaymentMethodEnum paymentMethod) {
        validateSupplier(supplier);
        validatePaymentMethod(paymentMethod);

        this.supplier = supplier;
        this.paymentMethod = paymentMethod;
    }

    public void addItem(Product product, Integer quantity) {
        OrderItem item = new OrderItem(product, quantity);
        items.add(item);
    }

    public void removeItem(Product product) {
        items.removeIf(item ->
                item.getProduct().equals(product));
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

    public Long getId() {
        return id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items);
    }
}
