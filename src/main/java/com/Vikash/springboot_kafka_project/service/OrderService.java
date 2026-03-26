package com.Vikash.springboot_kafka_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vikash.springboot_kafka_project.event.OrderCreatedEvent;
import com.Vikash.springboot_kafka_project.producer.OrderEventProducer;

@Service
public class OrderService {
	@Autowired
	private OrderEventProducer orderEventProducer;
	
	public void createOrder(OrderCreatedEvent event) {
		orderEventProducer.publishOrderEvent(event);
	}
}
