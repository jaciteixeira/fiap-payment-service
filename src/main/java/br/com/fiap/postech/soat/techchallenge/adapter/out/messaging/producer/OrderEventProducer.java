//	package br.com.fiap.postech.soat.techchallenge.adapter.out.messaging.producer;
//
//    import br.com.fiap.postech.soat.techchallenge.adapter.out.messaging.event.OrderCreatedEvent;
//	import br.com.fiap.postech.soat.techchallenge.domain.models.Order;
//	import br.com.fiap.postech.soat.techchallenge.domain.models.OrderItem;
//	import com.fasterxml.jackson.databind.ObjectMapper;
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.kafka.core.KafkaTemplate;
//    import org.springframework.stereotype.Component;
//
//	import java.util.List;
//	import java.util.Random;
//
//	@Component
//	public class OrderEventProducer {
//
//		@Autowired
//		private ObjectMapper objectMapper;
//
//	    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;
//	    private final Random random = new Random();
//
//	    public OrderEventProducer(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
//	        this.kafkaTemplate = kafkaTemplate;
//	    }
//
//	    public boolean publishOrderCreated(Order event) {
//	    	int partition = random.nextInt(2);
//			OrderCreatedEvent orderEvent = OrderCreatedEvent.builder()
//					.id(event.getId())
//					.items(event.getItems())
//					.observation(event.getObservation())
//					.number(event.getNumber())
//					.build();
//	        try {
//	            // O método send retorna um ListenableFuture
//				String json = objectMapper.writeValueAsString(event);
////				System.out.println("Event JSON >>>>>>>>>>>> " + json);
//	            kafkaTemplate.send("order-created", orderEvent).get(); // get() bloqueia até a conclusão
////				System.out.println("Event: >>>>>>>>>>> "+event.toString());
//	            return true; // Envio bem-sucedido
//	        } catch (Exception e) {
//	            // Logar o erro seria uma boa prática
//	            e.printStackTrace();
//	            System.out.println("Envio falhou!!!");
//	            return false; // Envio falhou
//	        }
//	    }
//	}
