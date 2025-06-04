package br.com.fiap.postech.soat.techchallenge.adapter.in.web.dto.response;

public record OrderItemResponse(
        ProductResponse product,
        Integer quantity
) {
}
