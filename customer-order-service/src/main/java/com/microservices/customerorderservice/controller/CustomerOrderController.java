package com.microservices.customerorderservice.controller;

import com.microservices.customerorderservice.models.Customer;
import com.microservices.customerorderservice.models.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CustomerOrderController {

    @Autowired
    RestTemplate restTemplate;


    List<Object> customerOrdersList=new ArrayList<>();

    @GetMapping("/{orderId}")
    public List<Object> getOrderDetails(@PathVariable int orderId){
        customerOrdersList.removeAll(customerOrdersList);
        Orders orders=restTemplate.getForObject("http://order-info/orders-service/orders/"+orderId, Orders.class);
        Customer customer=restTemplate.getForObject("http://customer-info/customer-service/customers/"+orders.getCustomerId(), Customer.class);
        customerOrdersList.add(customer);
        customerOrdersList.add(orders);
        return customerOrdersList;

    }
    @GetMapping("/customers")
    public ResponseEntity<Customer[]> getALlCustomers(){
        ResponseEntity<Customer[]> customers=restTemplate.getForEntity("http://customer-info/customer-service/customers",Customer[].class);
        return customers;

    }

    @PostMapping("/customer-registration")
    public ResponseEntity<String> customerRegistration(@RequestBody Customer customer){
        ResponseEntity<String> result=restTemplate.postForEntity("http://customer-info/customer-service/customers",customer, String.class);
        return result;
    }

    @PostMapping("/place-orders")
    public ResponseEntity<String> placeOrder(@RequestBody Orders orders){
        orders.setOrderBill(1000);
        ResponseEntity<String>responseEntity=restTemplate.postForEntity("http://order-info/orders-service/orders",orders, String.class);
        return responseEntity;
    }

    @PutMapping("/update-customer")
    public Customer updateCustomer(@RequestBody Customer customer){
        restTemplate.put("http://customer-info/customer-service/customers/",customer);
        return customer;
    }
    @DeleteMapping("/delete-customer/{id}")
    public String  deleteCustomer(@PathVariable int id){
        restTemplate.delete("http://customer-info/customer-service/customers/"+id);
        return "Customer Deleted successfully with id "+id;
    }

}
