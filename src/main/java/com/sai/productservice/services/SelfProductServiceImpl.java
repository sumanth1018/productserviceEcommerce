package com.sai.productservice.services;

import com.sai.productservice.dtos.GenericProductDto;
import com.sai.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("selfProductServiceImpl")
//@Primary   // There are two classes fakeStoreProductService and SelfProductServiceImpl. This creates a confusion to dependency injection. So, Meke this as default by setting it as primary
public class SelfProductServiceImpl implements  ProductService {
    private ProductRepository productRepository;
    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public GenericProductDto getProductById(Long id) {

        return new GenericProductDto();
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public List<GenericProductDto> getProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }
}
