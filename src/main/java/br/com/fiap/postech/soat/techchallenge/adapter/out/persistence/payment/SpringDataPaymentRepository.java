package br.com.fiap.postech.soat.techchallenge.adapter.out.persistence.payment;

import br.com.fiap.postech.soat.techchallenge.adapter.out.persistence.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataPaymentRepository extends JpaRepository<PaymentEntity, UUID> {
    Optional<PaymentEntity> findByOrderId(UUID orderId);
}
