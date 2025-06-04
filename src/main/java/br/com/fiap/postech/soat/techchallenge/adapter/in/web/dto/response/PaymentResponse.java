package br.com.fiap.postech.soat.techchallenge.adapter.in.web.dto.response;

import br.com.fiap.postech.soat.techchallenge.domain.models.PaymentStatus;

import java.util.UUID;

public record PaymentResponse(
        UUID id,
        String qrCode,
        PaymentStatus status
) {
}