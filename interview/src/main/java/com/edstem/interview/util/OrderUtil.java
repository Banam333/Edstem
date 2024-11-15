package com.edstem.interview.util;

import com.edstem.interview.dao.entity.Order;
import com.edstem.interview.exception.InvalidRequestException;
import com.edstem.interview.model.Item;
import com.edstem.interview.model.OrderRequest;
import com.edstem.interview.model.OrderResponse;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class OrderUtil {
    public static void validateOrderRequest(OrderRequest orderRequest) {
        if (Objects.isNull(orderRequest)) {
            throw new InvalidRequestException("Input Request is null");
        }
        if (orderRequest.getItems().isEmpty()) {
            throw new InvalidRequestException("No items in Order");
        }
        for (Item item: orderRequest.getItems()) {
            validateOrderItem(item);
        }

    }

    private static void validateOrderItem(Item item) {
        if (!StringUtils.hasText(item.getProductCode())) {
            throw new InvalidRequestException("Product code cannot be empty");
        }
        if (item.getQuantity()<=0) {
            throw new InvalidRequestException("Quantity should be positive");
        }
        if (item.getUnitPrice()<=0) {
            throw new InvalidRequestException("Unit Price should be positive");
        }
    }

    public static OrderResponse createOrderResponse(Order order) {

        Double totalAmount = order.getItems().stream().map(orderItem -> orderItem.getUnitPrice().doubleValue())
                .mapToDouble(Double::doubleValue).sum();
        return new OrderResponse(
                order.getOrderNumber(),
                order.getStatus().toString(),
                totalAmount,
                order.getCreatedAt(),
                order.getItems()
        );
    }
}
