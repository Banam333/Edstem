package com.edstem.interview.service;

import com.edstem.interview.model.OrderRequest;
import com.edstem.interview.model.OrderResponse;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);
}
