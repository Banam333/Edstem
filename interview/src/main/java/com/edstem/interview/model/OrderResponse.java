package com.edstem.interview.model;

import com.edstem.interview.dao.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class OrderResponse {
    private String orderNumber;
    private String status;
    private Double totalAmount;
    private LocalDateTime createdAt;
    private List<OrderItem> items;
}
