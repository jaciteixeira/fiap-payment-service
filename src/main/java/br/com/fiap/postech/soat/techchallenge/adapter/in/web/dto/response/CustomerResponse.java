package br.com.fiap.postech.soat.techchallenge.adapter.in.web.dto.response;

import java.util.UUID;

public record CustomerResponse(
        UUID id,
        String name,
        String cpf,
        String email,
        String phone
) {
}
