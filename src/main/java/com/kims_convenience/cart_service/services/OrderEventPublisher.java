package com.kims_convenience.cart_service.services;

import com.kims_convenience.cart_service.dto.oms.OrderPlacedEvent;
import com.kims_convenience.cart_service.entities.Order;
import com.kims_convenience.cart_service.entities.OrderStatus;
import com.kims_convenience.cart_service.exceptions.OrderNotFoundException;
import com.kims_convenience.cart_service.mappers.OrderMapper;
import com.kims_convenience.cart_service.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class OrderEventPublisher {

    private static final Logger logger = LoggerFactory.getLogger(OrderEventPublisher.class);

    @Autowired
    private KafkaTemplate<String, OrderPlacedEvent> orderPlacedEventKafkaTemplate;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;


    public void placeOrder(String orderId) {
        logger.info("[placeOrder] OrderId={}", orderId);

        Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
        order.setOrderStatus(OrderStatus.PLACED);
        OrderPlacedEvent orderPlacedEvent = getOrderPlacedEvent(order);

        logger.info("[placeOrder] OrderPlacedEvent={}", orderPlacedEvent.toLogString());

        orderPlacedEventKafkaTemplate.send("order.placed", orderPlacedEvent);
    }

    private OrderPlacedEvent getOrderPlacedEvent(Order order) {
        OrderPlacedEvent event = new OrderPlacedEvent();
        event.setEventTime(ZonedDateTime.now());
        event.setOrder(orderMapper.toOmsOrder(order));
        return event;
    }
}
