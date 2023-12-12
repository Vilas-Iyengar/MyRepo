package com.microservices.orderservice.controller;

import com.microservices.orderservice.models.Orders;
import com.microservices.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders-service")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders/{id}")
    public Orders getOrders(@PathVariable int id){
        return orderService.findOrder(id);
    }

    @PostMapping("/orders")
    public String addNewOrder(@RequestBody Orders orders){
        return orderService.addOrder(orders);
    }


}
