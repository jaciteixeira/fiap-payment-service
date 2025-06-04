package br.com.fiap.postech.soat.techchallenge.domain.ports.in.commands;

import java.util.UUID;

public record OrderItemCommand (UUID productId, int quantity) {
}
