package br.com.fiap.postech.soat.techchallenge.domain.ports.in;

import java.util.UUID;

public interface PaymentOrderUseCase {
    void updateOrderByPayment(UUID orderId);
}
