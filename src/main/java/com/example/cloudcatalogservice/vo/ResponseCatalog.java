package com.example.cloudcatalogservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCatalog {
    String productId;
    String productName;
    Integer unitPrice;
    Integer stock;
    Date createdAt;
}
