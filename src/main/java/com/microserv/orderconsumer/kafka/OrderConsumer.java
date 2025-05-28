package com.microserv.orderconsumer.kafka;

import com.microserv.orderconsumer.entity.Order;
import com.microserv.orderconsumer.repository.OrderRepository;
import com.microserv.orderservice.model.OrderRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private final OrderRepository orderRepository;

    public OrderConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "order-created", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderRequest orderRequest) {
        Order order = new Order(
                orderRequest.getOrderId(),
                orderRequest.getProduct(),
                orderRequest.getQuantity()
        );
        orderRepository.save(order);

        System.out.println("Order saved to BD: " + order.getOrderId());
    }
}
