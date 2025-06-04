package br.com.fiap.postech.soat.techchallenge.domain.ports.in;

import java.math.BigDecimal;
import java.util.UUID;

public interface PaymentGatewayPort {
    String qrDynamic(BigDecimal amount, UUID id);
}
