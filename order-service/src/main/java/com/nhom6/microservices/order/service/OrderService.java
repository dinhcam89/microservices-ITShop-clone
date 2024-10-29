package com.nhom6.microservices.order.service;

import com.nhom6.microservices.order.client.InventoryClient;
import com.nhom6.microservices.order.dto.OrderRequest;
import com.nhom6.microservices.order.event.OrderPlacedEvent;
import com.nhom6.microservices.order.exception.AppException;
import com.nhom6.microservices.order.exception.ErrorCode;
import com.nhom6.microservices.order.model.Order;
import com.nhom6.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    @Autowired
    private  OrderRepository orderRepository;
    @Autowired
    private  InventoryClient inventoryClient;
    @Autowired
    private  KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(OrderRequest orderRequest) {
        // Kiểm tra tồn kho
        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if (isProductInStock) {
            // Thực hiện giảm số lượng trong kho
            boolean deductResult = inventoryClient.deductQuantity(orderRequest.skuCode(), orderRequest.quantity());
            if (!deductResult) {
                throw new AppException(ErrorCode.INVENTORY_DEDUCTION_FAILED);
            }

            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);

            OrderPlacedEvent orderPlacedEvent = OrderPlacedEvent.newBuilder()
                    .setOrderNumber(order.getOrderNumber())
                    .setEmail(orderRequest.userDetails().email())
                    .setFirstName(orderRequest.userDetails().firstName())
                    .setLastName(orderRequest.userDetails().lastName())
                    .build();

            log.info("OrderPlacedEvent before sending to Kafka: {}", orderPlacedEvent);

            if (orderPlacedEvent.getOrderNumber() == null || orderPlacedEvent.getEmail() == null
                    || orderPlacedEvent.getFirstName() == null || orderPlacedEvent.getLastName() == null) {
                throw new IllegalArgumentException("OrderPlacedEvent has null fields");
            }

            kafkaTemplate.send("order-placed", orderPlacedEvent);
        } else {
            throw new AppException(ErrorCode.INSUFFICIENT_INVENTORY);
        }
    }
}
