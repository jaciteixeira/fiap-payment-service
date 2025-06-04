package br.com.fiap.postech.soat.techchallenge.domain.ports.out;


import br.com.fiap.postech.soat.techchallenge.domain.models.Payment;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository {
    void save(Payment payment);
    void update(Payment payment);
    Optional<Payment> findById(UUID id);
    Optional<Payment> findByOrderId(UUID orderId);
}
