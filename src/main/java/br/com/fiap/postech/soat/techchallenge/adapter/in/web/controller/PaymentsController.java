package br.com.fiap.postech.soat.techchallenge.adapter.in.web.controller;

import br.com.fiap.postech.soat.techchallenge.adapter.in.web.api.PaymentAPI;
import br.com.fiap.postech.soat.techchallenge.adapter.in.web.dto.response.PaymentResponse;
import br.com.fiap.postech.soat.techchallenge.adapter.in.web.mapper.PaymentResponseMapper;
import br.com.fiap.postech.soat.techchallenge.adapter.out.mapper.PaymentMapper;
import br.com.fiap.postech.soat.techchallenge.domain.models.Payment;
import br.com.fiap.postech.soat.techchallenge.domain.ports.in.ManagePaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentsController implements PaymentAPI {

    private final ManagePaymentUseCase useCase;
    private final PaymentResponseMapper mapper;

    @Override
    public ResponseEntity<PaymentResponse> getByOrderId(UUID orderId) {
        Payment payment = useCase.getByOrderId(orderId);
        PaymentResponse response = mapper.toResponse(payment);
        return ResponseEntity.ok(response);
    }
}
