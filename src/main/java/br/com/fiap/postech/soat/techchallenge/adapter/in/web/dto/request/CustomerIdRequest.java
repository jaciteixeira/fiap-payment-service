package br.com.fiap.postech.soat.techchallenge.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record CustomerIdRequest(
        @NotNull(message = "{customer.id.notnull}")
        UUID id
) {}
