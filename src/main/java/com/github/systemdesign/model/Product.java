package com.github.systemdesign.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class Product {
    UUID id;
    String productName;
    String productUrl;
    String productDescription;

    public Product(String productName) {
        id = UUID.randomUUID();
        this.productName = productName;
    }
}
