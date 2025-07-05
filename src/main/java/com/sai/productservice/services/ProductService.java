package com.sai.productservice.services;

import com.sai.productservice.dtos.GenericProductDto;
import com.sai.productservice.exceptions.NotFoundException;
import com.sai.productservice.models.Product;
import com.sai.productservice.security.JwtObject;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id, Long UserIdTryingToAccess) throws NotFoundException;    // Return the Product

    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getProducts();

    GenericProductDto deleteProductById(Long id);

    List<GenericProductDto> getAllProducts();


}
