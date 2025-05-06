package com.kims_convenience.cart_service.services;

import com.kims_convenience.cart_service.dto.order_event.OrderSubmittedEvent;
import com.kims_convenience.cart_service.entities.Order;
import com.kims_convenience.cart_service.entities.OrderStatus;
import com.kims_convenience.cart_service.exceptions.AddressNotFoundException;
import com.kims_convenience.cart_service.exceptions.OrderNotFoundException;
import com.kims_convenience.cart_service.exceptions.PaymentInstrumentNotFoundException;
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
    private KafkaTemplate<String, OrderSubmittedEvent> orderPlacedEventKafkaTemplate;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;


    public void submitOrder(String orderId) {
        logger.info("[submitOrder] OrderId={}", orderId);

        Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));

        if (order.getAddress() == null) {
            throw new AddressNotFoundException(orderId);
        }
        if (order.getPaymentInstrument() == null) {
            throw new PaymentInstrumentNotFoundException(orderId);
        }

        order.setOrderStatus(OrderStatus.SUBMITTED);

        OrderSubmittedEvent orderSubmittedEvent = getOrderSubmittedEvent(order);

        logger.info("[submitOrder] OrderSubmittedEvent={}", orderSubmittedEvent.toLogString());

        orderPlacedEventKafkaTemplate.send("order.submitted", orderSubmittedEvent);
    }

    private OrderSubmittedEvent getOrderSubmittedEvent(Order order) {
        OrderSubmittedEvent event = new OrderSubmittedEvent();
        event.setEventTime(ZonedDateTime.now());
        event.setOrder(orderMapper.toOmsOrder(order));
        return event;
    }
}
