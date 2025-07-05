package com.sai.productservice.dtos;

import com.sai.productservice.security.JwtObject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class CategoryDto {
    private String name;

    private List<ProductDto> products;

}
