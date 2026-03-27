package com.Vikash.springboot_kafka_project.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.Vikash.springboot_kafka_project.entity.Order;
import com.Vikash.springboot_kafka_project.event.OrderCreatedEvent;
import com.Vikash.springboot_kafka_project.repository.OrderRepository;

@Service
public class OrderEventConsumer {

	@Autowired
	private OrderRepository orderRepository;
	
	@KafkaListener(topics = "order-created-topic", groupId = "order-group")
	public void consume(OrderCreatedEvent event) {
		
		Order order = new Order();
		
		order.setProductid(event.getProductId());
		order.setQuantity(event.getQuantity());
		order.setStatus("CREATED");
		
		orderRepository.save(order);

        System.out.println("Order saved to DB: " + event.getProductId());
	}
}
