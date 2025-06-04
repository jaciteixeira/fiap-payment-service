package br.com.fiap.postech.soat.techchallenge.domain.ports.out;

import br.com.fiap.postech.soat.techchallenge.domain.models.Order;
import br.com.fiap.postech.soat.techchallenge.domain.models.OrderItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderItemRepository {
    void save(List<OrderItem> items, Order order);
    Optional<OrderItem> findOrderItemById(UUID id);
    List<OrderItem> findItemsByOrder(Order order);
    void updateOrderItem(UUID id, UUID orderId, UUID productId);
}
