package com.hulysses.eagleerp;

import com.hulysses.eagleerp.order.PurchaseOrder;
import com.hulysses.eagleerp.order.repository.PurchaseOrderRepository;
import com.hulysses.eagleerp.order.service.PurchaseOrderService;
import com.hulysses.eagleerp.payment.PaymentMethodEnum;
import com.hulysses.eagleerp.payment.adapter.ExternalPaymentApi;
import com.hulysses.eagleerp.payment.adapter.ExternalPaymentGatewayAdapter;
import com.hulysses.eagleerp.payment.adapter.PaymentGateway;
import com.hulysses.eagleerp.payment.factory.PaymentStrategyFactory;
import com.hulysses.eagleerp.payment.service.PaymentService;
import com.hulysses.eagleerp.product.Product;
import com.hulysses.eagleerp.supplier.Supplier;

import java.math.BigDecimal;

public class EagleApplication {

    public static void main(String[] args) {

        PaymentGateway paymentGateway =
                new ExternalPaymentGatewayAdapter(new ExternalPaymentApi());

        PaymentStrategyFactory paymentStrategyFactory =
                new PaymentStrategyFactory();

        PaymentService paymentService =
                new PaymentService(paymentStrategyFactory, paymentGateway);

        PurchaseOrderRepository purchaseOrderRepository =
                new PurchaseOrderRepository();

        PurchaseOrderService purchaseOrderService =
                new PurchaseOrderService(
                        paymentService,
                        purchaseOrderRepository
                );

        Supplier supplier = new Supplier(
                "Dell",
                "contato@dell.com",
                "(11)99999-9999",
                "São Paulo",
                "12.345.678/0001-99"
        );

        Product notebook = new Product(
                "Notebook Dell Inspiron",
                new BigDecimal("4500.00"),
                supplier
        );

        Product mouse = new Product(
                "Mouse Dell",
                new BigDecimal("120.00"),
                supplier
        );

        Product keyboard = new Product(
                "Keyboard Dell",
                new BigDecimal("350.00"),
                supplier
        );

        PurchaseOrder orderOne =
                purchaseOrderService.createOrder(
                        supplier,
                        PaymentMethodEnum.PIX
                );

        orderOne.addItem(notebook, 2);
        orderOne.addItem(mouse, 3);
        purchaseOrderService.checkout(orderOne);

        PurchaseOrder orderTwo =
                purchaseOrderService.createOrder(
                        supplier,
                        PaymentMethodEnum.CREDIT_CARD
                );

        orderTwo.addItem(keyboard, 4);
        orderTwo.addItem(mouse, 2);
        purchaseOrderService.checkout(orderTwo);

        System.out.println("--------------------------------");
        System.out.println("        PURCHASE ORDERS         ");
        System.out.println("--------------------------------");

        purchaseOrderService.findAll().forEach(order -> {
            System.out.println("Supplier: " + order.getSupplier().getName());
            System.out.println("Payment: " + order.getPaymentMethod());
            System.out.println("Items: " + order.getItems().size());
            System.out.println("Total: R$ " + order.calculateTotal());
            System.out.println("--------------------------------");
        });
    }
}
