package com.hulysses.eagleerp.payment.factory;

import com.hulysses.eagleerp.payment.InvalidPaymentException;
import com.hulysses.eagleerp.payment.PaymentMethodEnum;
import com.hulysses.eagleerp.payment.strategy.BoletoPaymentStrategy;
import com.hulysses.eagleerp.payment.strategy.CreditCardPaymentStrategy;
import com.hulysses.eagleerp.payment.strategy.PaymentStrategy;
import com.hulysses.eagleerp.payment.strategy.PixPaymentStrategy;

public class PaymentStrategyFactory {
    public PaymentStrategy create(PaymentMethodEnum paymentMethod) {
        validatePaymentMethod(paymentMethod);

        return switch (paymentMethod) {
            case PIX -> new PixPaymentStrategy();
            case CREDIT_CARD -> new CreditCardPaymentStrategy();
            case BOLETO -> new BoletoPaymentStrategy();
        };
    }

    private void validatePaymentMethod(PaymentMethodEnum paymentMethod) {
        if (paymentMethod == null) {
            throw new InvalidPaymentException("Payment method is required.");
        }
    }
}
