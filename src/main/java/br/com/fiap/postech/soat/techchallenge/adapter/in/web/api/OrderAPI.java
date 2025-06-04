package br.com.fiap.postech.soat.techchallenge.adapter.in.web.api;

import br.com.fiap.postech.soat.techchallenge.adapter.in.web.dto.request.*;
import br.com.fiap.postech.soat.techchallenge.adapter.in.web.dto.response.OrderResponse;
import br.com.fiap.postech.soat.techchallenge.domain.models.OrderStatus;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/orders")
public interface OrderAPI {

    @GetMapping
    ResponseEntity<List<OrderResponse>> getOrders(@RequestParam(required = false) OrderStatus status, @RequestParam(required = false) UUID customerId);

    @GetMapping("/{id}")
    ResponseEntity<OrderResponse> getOrderById(@Valid @PathVariable UUID id);

    @PostMapping
    ResponseEntity<Void> createOrder(@Valid @RequestBody CreateOrderRequest orderRequest);

    @PatchMapping("/{id}")
    ResponseEntity<Void> updateOrderStatusById(@PathVariable(name = "id") UUID orderId, @Valid @RequestBody UpdateOrderRequest orderRequest);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteOrder(@PathVariable UUID id);
}
