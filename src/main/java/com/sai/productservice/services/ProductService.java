package com.sai.productservice.services;

import com.sai.productservice.dtos.GenericProductDto;
import com.sai.productservice.exceptions.NotFoundException;
import com.sai.productservice.models.Product;
import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id) throws NotFoundException;    // Return the Product

    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getProducts();

    GenericProductDto deleteProductById(Long id);

    List<GenericProductDto> getAllProducts();


}
