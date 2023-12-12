package com.microservices.customerorderservice.models;

import lombok.*;




@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Orders {

    private int orderId;
    private int customerId;
    private String orderName;
    private double orderBill;

}
