package br.com.fiap.postech.soat.techchallenge.adapter.in.web.api;

import br.com.fiap.postech.soat.techchallenge.adapter.in.web.dto.response.PaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/payments")
public interface PaymentAPI {

    @GetMapping
    ResponseEntity<PaymentResponse> getByOrderId(@RequestParam UUID orderId);
}
