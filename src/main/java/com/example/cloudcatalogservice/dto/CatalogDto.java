package com.example.cloudcatalogservice.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CatalogDto implements Serializable {

    String productId;
    Integer qty;
    Integer unitPrice;
    Integer totalPrice;

    String orderId;
    String userId;

}
