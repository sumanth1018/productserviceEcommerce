package com.sai.productservice.dtos;

import com.sai.productservice.models.Category;
import com.sai.productservice.models.Price;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private String title;
    private String description;
    private String image;



    private Price price;  // Used double because the fakestore api uses double, can use any data type you want




}
