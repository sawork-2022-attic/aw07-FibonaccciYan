package com.example.delivery;

import com.example.model.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class OrderDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderDeliveryApplication.class, args);
	}

	@Bean
	public Consumer<Order> orderDeliver() {
		return new OrderDeliverer();
	}
}
