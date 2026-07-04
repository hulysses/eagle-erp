package com.hulysses.eagleerp.product;

import com.hulysses.eagleerp.supplier.Supplier;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private Supplier supplier;

    public Product(String name, BigDecimal price, Supplier supplier) {
        validateName(name);
        validatePrice(price);
        validateSupplier(supplier);

        this.name = name;
        this.price = price;
        this.supplier = supplier;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name is required.");
        }
    }

    private void validatePrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Product price must be greater than zero.");
        }
    }

    private void validateSupplier(Supplier supplier) {
        if (supplier == null) {
            throw new IllegalArgumentException("Supplier is required.");
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
