package com.example.delivery;

import com.example.model.Item;
import com.example.model.Order;
import com.example.model.Statuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.function.Consumer;

public class OrderDeliverer implements Consumer<Order> {

    private StreamBridge streamBridge;

    @Autowired
    public void setStreamBridge(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Override
    public void accept(Order order) {
        System.out.println(order.getStatus() + " " + order.getUuid());

        for(Item item: order.getItems()) {
            if(item.getQuantity() <= 0) {
                order.setStatus(Statuses.DECLINED.name());
                streamBridge.send("order-declined", message(order));
                return;
            }
        }
        order.setStatus(Statuses.APPROVED.name());
        streamBridge.send("order-approved", message(order));

        System.out.println(order.getStatus() + " " + order.getUuid());
    }

    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }

}
