package com.microservices.customerorderservice.models;


import lombok.*;




@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer {
    private int Id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
}
