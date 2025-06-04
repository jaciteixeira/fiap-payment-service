package br.com.fiap.postech.soat.techchallenge.adapter.out.web;

import br.com.fiap.postech.soat.techchallenge.domain.ports.in.PaymentGatewayPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class PaymentGatewayPortImpl implements PaymentGatewayPort {

    private final MercadoPagoGateway mercadoPagoGateway;

    @Override
    public String qrDynamic(BigDecimal amount, UUID paymentId) {
        log.info("Generating dynamic QR code for payment ID: {}, amount: {}", paymentId, amount);
        return mercadoPagoGateway.qrDynamic(paymentId, amount);
    }
}
