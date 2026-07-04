package com.hulysses.eagleerp.product;

import com.hulysses.eagleerp.supplier.Supplier;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private Supplier supplier;

    public Product(String name, BigDecimal price, Supplier supplier) {
        this.name = name;
        this.price = price;
        this.supplier = supplier;
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
