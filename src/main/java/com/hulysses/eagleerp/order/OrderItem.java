package com.hulysses.eagleerp.order;

import com.hulysses.eagleerp.product.Product;

import java.math.BigDecimal;

public class OrderItem {
    private Product product;
    private Integer quantity;

    public OrderItem(Product product, Integer quantity) {
        validateProduct(product);
        validateQuantity(quantity);

        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal calculateSubtotal() {
        return product.getPrice()
                .multiply(BigDecimal.valueOf(quantity));
    }

    private void validateProduct(Product product) {
        if (product == null) {
            throw new InvalidOrderException("Product is required.");
        }
    }

    private void validateQuantity(Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new InvalidOrderException("Quantity must be greater than zero.");
        }
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
