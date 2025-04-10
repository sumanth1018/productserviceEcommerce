package com.sai.productservice.thirdpartyclients.productservice;

import com.sai.productservice.dtos.GenericProductDto;
import com.sai.productservice.exceptions.NotFoundException;
import com.sai.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;

import java.util.List;

public interface ThirdPartyProductServiceClient {

    FakeStoreProductDto getProductById(Long id) throws NotFoundException;    // Return the Product

    FakeStoreProductDto createProduct(GenericProductDto product);

    List<FakeStoreProductDto> getProducts();

    FakeStoreProductDto deleteProductById(Long id);

}
