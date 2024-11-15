package com.edstem.interview;

import com.edstem.interview.model.OrderRequest;
import com.edstem.interview.model.OrderResponse;
import com.edstem.interview.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/api/v1/orders")
    public OrderResponse createOrder(@RequestBody @Validated OrderRequest request) {
        return orderService.createOrder(request);
    }
}
