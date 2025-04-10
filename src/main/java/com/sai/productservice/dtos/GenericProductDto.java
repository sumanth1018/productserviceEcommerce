package com.sai.productservice.dtos;

import com.sai.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private  double price;  // Used double because the fakestore api uses double, can use any data type you want

}
