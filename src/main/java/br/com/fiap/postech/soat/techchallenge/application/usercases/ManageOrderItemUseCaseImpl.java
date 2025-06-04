package br.com.fiap.postech.soat.techchallenge.application.usercases;

import br.com.fiap.postech.soat.techchallenge.domain.models.Order;
import br.com.fiap.postech.soat.techchallenge.domain.models.OrderItem;
import br.com.fiap.postech.soat.techchallenge.domain.ports.in.ManageOrderItemUseCase;
import br.com.fiap.postech.soat.techchallenge.domain.ports.out.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManageOrderItemUseCaseImpl implements ManageOrderItemUseCase {

    private final OrderItemRepository orderItemRepository;

    @Override
    public void createOrderItems(List<OrderItem> items, Order order) {
        orderItemRepository.save(items, order);
    }
}
