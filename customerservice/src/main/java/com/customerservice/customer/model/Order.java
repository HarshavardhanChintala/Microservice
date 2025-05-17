package com.customerservice.customer.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Order{

    private int id;

    private int customerId;

    private String product;
    
    private int quantity;
    
    private String date;
    
}
