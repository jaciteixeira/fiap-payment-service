package br.com.fiap.postech.soat.techchallenge.adapter.out.messaging.event;

import br.com.fiap.postech.soat.techchallenge.domain.models.OrderItem;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class OrderCreatedEvent {
    private UUID id;
    //    private Customer customer;
//    private OrderStatus status;
    private String observation;
    private Integer number;
    private List<OrderItem> items;
}
