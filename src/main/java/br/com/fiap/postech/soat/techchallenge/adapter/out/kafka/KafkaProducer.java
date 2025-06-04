//package br.com.fiap.postech.soat.techchallenge.adapter.out.kafka;
//
//import lombok.extern.log4j.Log4j2;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Log4j2
//@Service
//public class KafkaProducer {
//
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void send(String topic, String message) {
//        log.info("Sending message to Kafka topic: {}", topic);
//        kafkaTemplate.send(topic, message);
//    }
//}
