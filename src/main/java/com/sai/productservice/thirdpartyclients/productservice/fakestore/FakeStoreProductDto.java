package com.sai.productservice.thirdpartyclients.productservice.fakestore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter   // Set the setter gor the all the variables
public class FakeStoreProductDto {

    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
