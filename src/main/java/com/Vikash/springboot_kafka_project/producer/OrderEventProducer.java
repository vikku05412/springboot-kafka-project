package com.Vikash.springboot_kafka_project.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.Vikash.springboot_kafka_project.event.OrderCreatedEvent;

@Service
public class OrderEventProducer {
	@Autowired
    private KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public void publishOrderEvent(OrderCreatedEvent event) {

        kafkaTemplate.send("order-created-topic", event);
}

}
