package com.edstem.interview.service.impl;

import com.edstem.interview.dao.OrderRepository;
import com.edstem.interview.dao.entity.Order;
import com.edstem.interview.dao.entity.OrderStatus;
import com.edstem.interview.model.OrderRequest;
import com.edstem.interview.model.OrderResponse;
import com.edstem.interview.service.OrderService;
import com.edstem.interview.util.OrderUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private OrderRepository repository;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        OrderUtil.validateOrderRequest(orderRequest);
        String orderNumber = UUID.randomUUID().toString();
        Order order = mapper.convertValue(orderRequest, Order.class);
        order.setOrderNumber(orderNumber);
        order.setStatus(OrderStatus.CREATED);
        order.setCreatedAt(LocalDateTime.now());
        repository.save(order);
        return OrderUtil.createOrderResponse(order);
    }
}
