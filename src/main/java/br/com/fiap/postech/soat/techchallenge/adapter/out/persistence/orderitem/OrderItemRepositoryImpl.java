package br.com.fiap.postech.soat.techchallenge.adapter.out.persistence.orderitem;

import br.com.fiap.postech.soat.techchallenge.adapter.out.mapper.OrderItemMapper;
import br.com.fiap.postech.soat.techchallenge.adapter.out.mapper.OrderMapper;
import br.com.fiap.postech.soat.techchallenge.adapter.out.persistence.order.OrderEntity;
import br.com.fiap.postech.soat.techchallenge.domain.models.Order;
import br.com.fiap.postech.soat.techchallenge.domain.models.OrderItem;
import br.com.fiap.postech.soat.techchallenge.domain.ports.out.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrderItemRepositoryImpl implements OrderItemRepository {

    private final SpringDataOrderItemRepository repository;
    private final OrderItemMapper orderItemMapper;
    private final OrderMapper orderMapper;


    @Override
    public void save(List<OrderItem> items, Order order) {
        OrderEntity orderEntity = orderMapper.toEntity(order);
        List<OrderItemEntity> entities = items.stream()
                .map(item -> orderItemMapper.toEntity(item, orderEntity))
                .toList();
        repository.saveAll(entities);
    }

    @Override
    public Optional<OrderItem> findOrderItemById(UUID id) {
        return repository.findOrderItemById(id)
                .map(orderItemMapper::toDomain);
    }

    @Override
    public List<OrderItem> findItemsByOrder(Order order) {
        OrderEntity orderEntity = orderMapper.toEntity(order);
        List<OrderItemEntity> entities = repository.findItemsByOrder(orderEntity);
        return entities.stream()
                .map(orderItemMapper::toDomain)
                .toList();
    }

    @Override
    public void updateOrderItem(UUID id, UUID orderId, UUID productId) {

    }
}
