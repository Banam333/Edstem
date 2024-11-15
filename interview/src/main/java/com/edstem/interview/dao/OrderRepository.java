package com.edstem.interview.dao;

import com.edstem.interview.dao.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class OrderRepository implements JpaRepository<Order, String> {
}
