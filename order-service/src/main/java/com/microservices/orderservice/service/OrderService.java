package com.microservices.orderservice.service;

import com.microservices.orderservice.models.Orders;
import com.microservices.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Orders findOrder(int id){
        Orders orders=orderRepository.findById(id).get();
        return orders;
    }

    public String addOrder(Orders orders){
       Orders orders1= orderRepository.save(orders);
        return "Orders added Successfully with id "+orders1.getOrderId();
    }


}
