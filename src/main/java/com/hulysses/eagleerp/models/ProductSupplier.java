package com.hulysses.eagleerp.models;

import java.math.BigDecimal;

public class ProductSupplier {
    private Long id;
    private Product product;
    private Supplier supplier;
    private BigDecimal supplierPrice;

    public ProductSupplier(Product product, Supplier supplier, BigDecimal supplierPrice) {
        this.product = product;
        this.supplier = supplier;
        this.supplierPrice = supplierPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public BigDecimal getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(BigDecimal supplierPrice) {
        this.supplierPrice = supplierPrice;
    }
}
