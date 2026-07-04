package com.hulysses.eagleerp.order.repository;

import com.hulysses.eagleerp.order.PurchaseOrder;

import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderRepository {

    private final List<PurchaseOrder> orders = new ArrayList<>();

    public void save(PurchaseOrder order) {
        orders.add(order);
    }

    public List<PurchaseOrder> findAll() {
        return new ArrayList<>(orders);
    }
}