package br.com.fiap.postech.soat.techchallenge.application.usercases;

import br.com.fiap.postech.soat.techchallenge.application.usercases.exceptions.NotFoundException;
import br.com.fiap.postech.soat.techchallenge.domain.models.*;
import br.com.fiap.postech.soat.techchallenge.domain.ports.in.*;
import br.com.fiap.postech.soat.techchallenge.domain.ports.in.commands.CreateOrderCommand;
import br.com.fiap.postech.soat.techchallenge.domain.ports.out.OrderRepository;
import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class ManageOrderUseCaseImpl implements ManageOrderUseCase {

    private final OrderRepository orderRepository;
    private final ManageCustomerUseCase customerUseCase;
    private final ManageOrderItemUseCase orderItemUseCase;
    private final ManageProductUseCase productUseCase;
    private final ManagePaymentUseCase paymentUseCase;

    @Override
    public Order getOrderById(UUID orderId) {
        log.info("Fetching order with ID: {}", orderId);
        return orderRepository.findOrderById(orderId).orElseThrow(() -> new NotFoundException("Order not found."));
    }

    @Override
    public List<Order> getOrdersByFilters(OrderStatus status, UUID customerId) {
        log.info("Fetching orders with status: {} and customer ID: {}", status, customerId);
        return orderRepository.findOrdersByFilters(status, customerId);
    }

    @Override
    public Order createOrder(CreateOrderCommand createOrderCommand) {
        log.info("Creating order with command: {}", createOrderCommand);
        List<OrderItem> orderItems = createOrderCommand.items().stream()
                .map(orderItem -> {
                    Product product = productUseCase.getProductById(orderItem.productId());
                    return new OrderItem(UUID.randomUUID(), orderItem.quantity(), product);
                })
                .toList();

        int totalPedidos = orderRepository.findAll().size();
        int nextOrderNumber = totalPedidos + 1;

        UUID customerId = (createOrderCommand.customerId() == null) ? UUID.fromString("dc821e5c-894a-4bdf-bded-e97b2657cb5a") : createOrderCommand.customerId();
        Customer customer = customerUseCase.getCustomerById(customerId);
        Order order = new Order(UUID.randomUUID(), customer, OrderStatus.AWAITING_PAYMENT, createOrderCommand.observation(), nextOrderNumber, orderItems);

        orderRepository.save(order);
        orderItemUseCase.createOrderItems(orderItems, order);
        paymentUseCase.create(order);

        return order;
    }

    @Override
    public void updateOrderStatus(UUID orderId, OrderStatus orderStatus) {
        log.info("Updating order status for order ID: {} to status: {}", orderId, orderStatus);
        Order order = getOrderById(orderId);
        OrderStatus status = order.getStatus();

        switch (status) {
            case AWAITING_PAYMENT:
                order.setStatus(OrderStatus.RECEIVED);
                break;
            case RECEIVED:
                order.setStatus(OrderStatus.IN_PREPARATION);
                break;
            case IN_PREPARATION:
                order.setStatus(OrderStatus.READY);
                break;
            case READY:
                order.setStatus(OrderStatus.FINALIZED);
                break;
        }
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(UUID orderID) {
    log.info("Deleting order with ID: {}", orderID);
        orderRepository.deleteById(orderID);
    }
}
