package com.kims_convenience.cart_service.dto.oms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPlacedEvent {

    private final String eventType = "order.placed";
    private ZonedDateTime eventTime;
    private Order order;

    public String toLogString() {
        return String.format("Event Type: %s, Event Time: %s, Order : %s",
                eventType,
                eventTime,
                order.toLogString()
        );
    }
}

