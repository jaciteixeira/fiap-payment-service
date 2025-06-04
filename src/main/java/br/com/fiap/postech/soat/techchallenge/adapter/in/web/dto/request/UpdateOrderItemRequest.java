package br.com.fiap.postech.soat.techchallenge.adapter.in.web.dto.request;

import java.util.List;

public record UpdateOrderItemRequest (
        Integer quantity,
        List<UpdateProductRequest> productRequests
) {
}
