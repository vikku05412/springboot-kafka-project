package com.Vikash.springboot_kafka_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Vikash.springboot_kafka_project.event.OrderCreatedEvent;
import com.Vikash.springboot_kafka_project.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	

	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public String createOrder(@RequestBody OrderCreatedEvent event) {
		orderService.createOrder(event);
		return "Order Event Published Successfully";
	}
}
