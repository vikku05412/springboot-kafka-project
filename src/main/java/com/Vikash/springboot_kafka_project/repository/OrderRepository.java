package com.Vikash.springboot_kafka_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vikash.springboot_kafka_project.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
