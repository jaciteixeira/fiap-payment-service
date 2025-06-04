package br.com.fiap.postech.soat.techchallenge.adapter.in.web.dto.response;

import br.com.fiap.postech.soat.techchallenge.domain.models.OrderStatus;

import java.util.List;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        String nameCustomer,
        String cpfCustomer,
        OrderStatus status,
        Integer number,
        List<OrderItemResponse> items
) {
}
